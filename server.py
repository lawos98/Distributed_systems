from orders_pb2 import *
from orders_pb2_grpc import *
import grpc
from concurrent.futures import ThreadPoolExecutor
from grpc_reflection.v1alpha import reflection


def print_color(text, color):
    colors = {
        'black': '\033[30m',
        'red': '\033[31m',
        'green': '\033[32m',
        'yellow': '\033[33m',
        'blue': '\033[34m',
        'purple': '\033[35m',
        'cyan': '\033[36m',
        'white': '\033[37m',
        'reset': '\033[0m'
    }
    if color not in colors:
        raise ValueError(f'Unknown color: {color}')
    print(f'{colors[color]}{text}{colors["reset"]}')


class OrderService(OrderServiceServicer):
    orders = {}

    def GetOrder(self, request, context):
        print_color(f"Server get order with request {request}", "cyan")
        order_id = request.id
        if order_id in self.orders:
            order = self.orders[order_id]
            return Order(id=order_id, items=order.items, user=order.user, shipping_address=order.shipping_address,
                         is_completed=order.is_completed, item_quantities=order.item_quantities)
        else:
            print_color(f"Order '{order_id}' not found", "red")
            context.set_details(f"Order '{order_id}' not found")
            context.set_code(grpc.StatusCode.NOT_FOUND)
            return Order()

    def CreateOrder(self, request, context):
        print_color(f"Server create order with request {request}", "yellow")
        order_id = request.id
        if order_id in self.orders:
            print_color(f"Order '{order_id}' already exists", "red")
            context.set_details(f"Order '{order_id}' already exists")
            context.set_code(grpc.StatusCode.ALREADY_EXISTS)
            return Order()
        else:
            order = Order(id=order_id, items=request.items, user=request.user,
                          shipping_address=request.shipping_address, is_completed=False,
                          item_quantities=request.item_quantities)
            self.orders[order_id] = order
            return order

    def UpdateOrder(self, request, context):
        print_color(f"Server update order with request {request}", "purple")
        order_id = request.id
        if order_id in self.orders:
            order = self.orders[order_id]
            for item in request.items:
                if item in order.items:
                    order.item_quantities[item] += request.item_quantities[item]
                else:
                    order.items.append(item)
                    order.item_quantities[item] = request.item_quantities[item]
            order.is_completed = request.is_completed
            return Order(id=order_id, items=order.items, user=order.user, shipping_address=order.shipping_address,
                         is_completed=order.is_completed, item_quantities=order.item_quantities)
        else:
            print_color(f"Order '{order_id}' not found", "red")
            context.set_details(f"Order '{order_id}' not found")
            context.set_code(grpc.StatusCode.NOT_FOUND)
            return Order()


def serve():
    server = grpc.server(ThreadPoolExecutor(max_workers=10))
    add_OrderServiceServicer_to_server(OrderService(), server)

    # Enable reflection
    SERVICE_NAMES = (
        DESCRIPTOR.services_by_name['OrderService'].full_name,
        reflection.SERVICE_NAME,
    )
    reflection.enable_server_reflection(SERVICE_NAMES, server)

    server.add_insecure_port('[::]:50051')
    print_color("Server Started", "green")
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    serve()

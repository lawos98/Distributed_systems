import grpc
import threading
from generated import *
import time

from subscriptions_pb2 import *
from subscriptions_pb2_grpc import *


def weather_condition(num):
    conditions = {
        0: "SUNNY",
        1: "CLOUDY",
        2: "RAINY",
        3: "SNOWY",
        4: "THUNDER",
        5: "FOGGY"
    }
    return conditions.get(num, "Invalid input")


def print_color(text, color):
    colors = {
        'red': '\033[31m',
        'green': '\033[32m',
        'yellow': '\033[33m',
        'blue': '\033[34m',
        'magenta': '\033[35m',
        'cyan': '\033[36m',
        'bright_red': '\033[91m',
        'bright_green': '\033[92m',
        'bright_yellow': '\033[93m',
        'bright_blue': '\033[94m',
        'bright_magenta': '\033[95m',
        'bright_cyan': '\033[96m',
    }
    reset = '\033[0m'
    print(f"{colors[color]}{text}{reset}")


def weather_response(stub, request):
    conditions = {
        WeatherTemperatureRequest: stub.GetWeatherByTemperature(request),
        WeatherTypeRequest: stub.GetWeatherByType(request),
        WeatherHumidityRequest: stub.GetWeatherByHumidity(request),
        WeatherPressureRequest: stub.GetWeatherByPressure(request),
        WeatherWindRequest: stub.GetWeatherByWind(request),
    }

    return conditions.get(type(request), "Invalid input")


def send_request(stub, request, color):
    # Retry loop with exponential backoff
    backoff = 1
    while True:
        try:
            responses = weather_response(stub, request)
            for response in responses:
                print("=============================================")
                print_color(f"For request {request}", color)
                print_color(f"City: {response.city}", color)
                print_color(f"Temperature: {response.temperature}", color)
                print_color(f"Humidity: {response.humidity}", color)
                print_color(f"Wind: {response.wind}", color)
                print_color(f"Pressure: {response.pressure}", color)
                print_color(f"Type: {weather_condition(response.type)}", color)
            break
        except grpc.RpcError as e:
            print(f"Error: {e.code()}: {e.details()}")
            if e.code() == grpc.StatusCode.INVALID_ARGUMENT: break

            # Sleep for an exponentially increasing amount of time before retrying
            time.sleep(backoff)
            backoff *= 2
        except Exception as e:
            print(f"An unexpected error occurred: {e}")
            break


def run():
    with grpc.insecure_channel("localhost:50051") as channel:
        stub = WeatherServiceStub(channel)

        requests = []

        requests.append(WeatherTemperatureRequest(city="Warsaw", temperature=20, range=10))
        requests.append(WeatherTypeRequest(city="Krakow", type=[SUNNY, SNOWY, FOGGY, RAINY, THUNDER]))
        requests.append(WeatherHumidityRequest(city="London", humidity=0.5, range=1))
        requests.append(WeatherPressureRequest(city="New York", pressure=1000, range=100))
        requests.append(WeatherWindRequest(city="Tokyo", wind=50, range=10))
        requests.append(WeatherPressureRequest(city="Nothing", pressure=1000, range=10))

        color_names = ['green', 'yellow', 'blue', 'magenta', 'cyan',
                       'bright_green', 'bright_yellow', 'bright_blue', 'bright_magenta', 'bright_cyan']

        # Create and start a new thread for each request
        threads = []
        for i in range(0, len(requests)):
            thread = threading.Thread(target=send_request, args=(stub, requests[i], color_names[i % len(color_names)]))
            thread.start()
            threads.append(thread)

        # Wait for all threads to finish
        for thread in threads:
            thread.join()


if __name__ == "__main__":
    run()

# excercise 3
# 3.0 start remote cluster settings and observe actors in cluster
# a) make screenshot of dependencies
# 3.1. Modify the Actor class MethodStateCounter and add/modify methods that return the following:
# a) - Get number of times an invoker name was called
# b) - Get a list of values computed by invoker name
# 3- Get state of all invokers
# 3.2 Modify method invoke to return a random int value between [5, 25]

# 3.3 Take a look on implement parallel Pi computation
# based on https://docs.ray.io/en/master/ray-core/examples/highly_parallel.html
#
# Implement calculating pi as a combination of actor (which keeps the
# state of the progress of calculating pi as it approaches its final value)
# and a task (which computes candidates for pi)

import time
import ray
import random

ray.init(address='ray://localhost:10001')


@ray.remote
class MethodStateCounter:
    def __init__(self):
        self.invokers = {"A": 0, "B": 0, "C": 0}
        # new line
        self.values = {"A": [], "B": [], "C": []}

    def invoke(self, name):
        time.sleep(0.5)
        self.invokers[name] += 1
        # change from one line to another
        # value = self.invokers[name]
        value = random.randint(5, 25)
        # new line
        self.values[name].append(value)
        return value

    def get_invoker_state(self, name):
        return self.invokers[name]

    def get_all_invoker_state(self):
        return self.invokers

    # new function
    def get_invoker_values(self, name):
        return self.values[name]


# 3.1

worker_invoker = MethodStateCounter.remote()

# Call the invoke method for invoker "A"
for _ in range(100):
    name = random.choice(["A", "B", "C"])
    worker_invoker.invoke.remote(name)

# Get the number of times invoker "A" was called
num_calls = ray.get(worker_invoker.get_invoker_state.remote("A"))
print(f"Invoker A was called {num_calls} times")

# Get the number of times invoker "B" was called
num_calls = ray.get(worker_invoker.get_invoker_state.remote("B"))
print(f"Invoker B was called {num_calls} times")

# Get the number of times invoker "C" was called
num_calls = ray.get(worker_invoker.get_invoker_state.remote("C"))
print(f"Invoker C was called {num_calls} times")

# Get the list of values computed by invoker "A"
values = ray.get(worker_invoker.get_invoker_values.remote("A"))
print(f"Values computed by invoker A: {values}")

# Get the list of values computed by invoker "B"
values = ray.get(worker_invoker.get_invoker_values.remote("B"))
print(f"Values computed by invoker B: {values}")

# Get the list of values computed by invoker "C"
values = ray.get(worker_invoker.get_invoker_values.remote("C"))
print(f"Values computed by invoker C: {values}")

# 3-

# Get the state of all invokers
all_invoker_state = ray.get(worker_invoker.get_all_invoker_state.remote())
print(f"State of all invokers: {all_invoker_state}")


# 3.3
@ray.remote
class PiCalculator:
    def __init__(self):
        self.total_points = 0
        self.points_in_circle = 0

    def update(self, points, total_points):
        self.points_in_circle += points
        self.total_points += total_points

    def get_pi_estimate(self):
        if self.total_points == 0:
            return 0
        return 4 * self.points_in_circle / self.total_points


@ray.remote
def compute_pi_batch(size):
    points = 0
    for _ in range(size):
        x = random.uniform(-1, 1)
        y = random.uniform(-1, 1)
        if x * x + y * y <= 1:
            points += 1
    return points


num_batches = 10000
batch_size = 10000

pi_calculator = PiCalculator.remote()

for _ in range(num_batches):
    points_in_circle = compute_pi_batch.remote(batch_size)
    pi_calculator.update.remote(points_in_circle, batch_size)

pi_estimate = ray.get(pi_calculator.get_pi_estimate.remote())
print(f"Pi estimate: {pi_estimate}")
ray.shutdown()

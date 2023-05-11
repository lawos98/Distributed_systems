# Exercises 1.1)Try using local bubble sort and remote bubble sort,
# show difference

import os

import numpy as np
import ray
import cProfile

ray.init(address='ray://localhost:10001')

tab = np.random.randint(100, size=5000)


def bubble_sort_local(arr):
    for i in range(len(arr)):
        for j in range(0, len(arr) - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


@ray.remote
def bubble_sort_remote(arr):
    return bubble_sort_local(arr)


os.cpu_count()


def run_local():
    results = [bubble_sort_local(tab) for _ in range(os.cpu_count())]
    return results


print('local run')
cProfile.run("run_local()")


def run_remote():
    results = ray.get([bubble_sort_remote.remote(tab) for _ in range(os.cpu_count())])
    return results


print('remote run')
cProfile.run("run_remote()")

ray.shutdown()

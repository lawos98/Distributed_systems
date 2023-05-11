# Exercises 2.1) Create large lists and python dictionaries,
# put them in object store. Write a Ray task to process them.

import ray

ray.init(address='ray://localhost:10001')


# Create a large list and dictionary
large_list = list(range(1000000))
large_dict = {i: i for i in range(1000000)}

# Put the list and dictionary in the object store
list_ref = ray.put(large_list)
dict_ref = ray.put(large_dict)


# Define a remote function to process the list and dictionary
@ray.remote
def process_data():
    # Get the list and dictionary from the object store
    data_list = ray.get(list_ref)
    data_dict = ray.get(dict_ref)

    # Process the data (e.g., compute the sum of the list and the sum of the values in the dictionary)
    list_sum = sum(data_list)
    dict_sum = sum(data_dict.values())

    # Return the results
    return list_sum, dict_sum


# Call the remote function
result_ref = process_data.remote()

# Get the result
result = ray.get(result_ref)
print(result)

ray.shutdown()

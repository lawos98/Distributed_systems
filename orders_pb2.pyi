from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Address(_message.Message):
    __slots__ = ["city", "country", "house_number", "street"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    COUNTRY_FIELD_NUMBER: _ClassVar[int]
    HOUSE_NUMBER_FIELD_NUMBER: _ClassVar[int]
    STREET_FIELD_NUMBER: _ClassVar[int]
    city: str
    country: str
    house_number: int
    street: str
    def __init__(self, house_number: _Optional[int] = ..., street: _Optional[str] = ..., city: _Optional[str] = ..., country: _Optional[str] = ...) -> None: ...

class CreateOrderRequest(_message.Message):
    __slots__ = ["id", "item_quantities", "items", "shipping_address", "user"]
    class ItemQuantitiesEntry(_message.Message):
        __slots__ = ["key", "value"]
        KEY_FIELD_NUMBER: _ClassVar[int]
        VALUE_FIELD_NUMBER: _ClassVar[int]
        key: str
        value: int
        def __init__(self, key: _Optional[str] = ..., value: _Optional[int] = ...) -> None: ...
    ID_FIELD_NUMBER: _ClassVar[int]
    ITEMS_FIELD_NUMBER: _ClassVar[int]
    ITEM_QUANTITIES_FIELD_NUMBER: _ClassVar[int]
    SHIPPING_ADDRESS_FIELD_NUMBER: _ClassVar[int]
    USER_FIELD_NUMBER: _ClassVar[int]
    id: int
    item_quantities: _containers.ScalarMap[str, int]
    items: _containers.RepeatedScalarFieldContainer[str]
    shipping_address: Address
    user: User
    def __init__(self, id: _Optional[int] = ..., items: _Optional[_Iterable[str]] = ..., user: _Optional[_Union[User, _Mapping]] = ..., shipping_address: _Optional[_Union[Address, _Mapping]] = ..., item_quantities: _Optional[_Mapping[str, int]] = ...) -> None: ...

class GetOrderRequest(_message.Message):
    __slots__ = ["id"]
    ID_FIELD_NUMBER: _ClassVar[int]
    id: int
    def __init__(self, id: _Optional[int] = ...) -> None: ...

class Order(_message.Message):
    __slots__ = ["id", "is_completed", "item_quantities", "items", "shipping_address", "user"]
    class ItemQuantitiesEntry(_message.Message):
        __slots__ = ["key", "value"]
        KEY_FIELD_NUMBER: _ClassVar[int]
        VALUE_FIELD_NUMBER: _ClassVar[int]
        key: str
        value: int
        def __init__(self, key: _Optional[str] = ..., value: _Optional[int] = ...) -> None: ...
    ID_FIELD_NUMBER: _ClassVar[int]
    IS_COMPLETED_FIELD_NUMBER: _ClassVar[int]
    ITEMS_FIELD_NUMBER: _ClassVar[int]
    ITEM_QUANTITIES_FIELD_NUMBER: _ClassVar[int]
    SHIPPING_ADDRESS_FIELD_NUMBER: _ClassVar[int]
    USER_FIELD_NUMBER: _ClassVar[int]
    id: int
    is_completed: bool
    item_quantities: _containers.ScalarMap[str, int]
    items: _containers.RepeatedScalarFieldContainer[str]
    shipping_address: Address
    user: User
    def __init__(self, id: _Optional[int] = ..., items: _Optional[_Iterable[str]] = ..., is_completed: bool = ..., user: _Optional[_Union[User, _Mapping]] = ..., shipping_address: _Optional[_Union[Address, _Mapping]] = ..., item_quantities: _Optional[_Mapping[str, int]] = ...) -> None: ...

class UpdateOrderRequest(_message.Message):
    __slots__ = ["id", "is_completed", "item_quantities", "items", "shipping_address", "user"]
    class ItemQuantitiesEntry(_message.Message):
        __slots__ = ["key", "value"]
        KEY_FIELD_NUMBER: _ClassVar[int]
        VALUE_FIELD_NUMBER: _ClassVar[int]
        key: str
        value: int
        def __init__(self, key: _Optional[str] = ..., value: _Optional[int] = ...) -> None: ...
    ID_FIELD_NUMBER: _ClassVar[int]
    IS_COMPLETED_FIELD_NUMBER: _ClassVar[int]
    ITEMS_FIELD_NUMBER: _ClassVar[int]
    ITEM_QUANTITIES_FIELD_NUMBER: _ClassVar[int]
    SHIPPING_ADDRESS_FIELD_NUMBER: _ClassVar[int]
    USER_FIELD_NUMBER: _ClassVar[int]
    id: int
    is_completed: bool
    item_quantities: _containers.ScalarMap[str, int]
    items: _containers.RepeatedScalarFieldContainer[str]
    shipping_address: Address
    user: User
    def __init__(self, id: _Optional[int] = ..., items: _Optional[_Iterable[str]] = ..., is_completed: bool = ..., user: _Optional[_Union[User, _Mapping]] = ..., shipping_address: _Optional[_Union[Address, _Mapping]] = ..., item_quantities: _Optional[_Mapping[str, int]] = ...) -> None: ...

class User(_message.Message):
    __slots__ = ["age", "firstname", "lastname"]
    AGE_FIELD_NUMBER: _ClassVar[int]
    FIRSTNAME_FIELD_NUMBER: _ClassVar[int]
    LASTNAME_FIELD_NUMBER: _ClassVar[int]
    age: int
    firstname: str
    lastname: str
    def __init__(self, firstname: _Optional[str] = ..., lastname: _Optional[str] = ..., age: _Optional[int] = ...) -> None: ...

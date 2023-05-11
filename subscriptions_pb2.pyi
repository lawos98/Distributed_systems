from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Optional as _Optional, Union as _Union

CLOUDY: WeatherType
DESCRIPTOR: _descriptor.FileDescriptor
FOGGY: WeatherType
RAINY: WeatherType
SNOWY: WeatherType
SUNNY: WeatherType
THUNDER: WeatherType

class WeatherHumidityRequest(_message.Message):
    __slots__ = ["city", "humidity", "range"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    HUMIDITY_FIELD_NUMBER: _ClassVar[int]
    RANGE_FIELD_NUMBER: _ClassVar[int]
    city: str
    humidity: float
    range: float
    def __init__(self, city: _Optional[str] = ..., humidity: _Optional[float] = ..., range: _Optional[float] = ...) -> None: ...

class WeatherPressureRequest(_message.Message):
    __slots__ = ["city", "pressure", "range"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    PRESSURE_FIELD_NUMBER: _ClassVar[int]
    RANGE_FIELD_NUMBER: _ClassVar[int]
    city: str
    pressure: float
    range: float
    def __init__(self, city: _Optional[str] = ..., pressure: _Optional[float] = ..., range: _Optional[float] = ...) -> None: ...

class WeatherResponse(_message.Message):
    __slots__ = ["city", "humidity", "pressure", "temperature", "type", "wind"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    HUMIDITY_FIELD_NUMBER: _ClassVar[int]
    PRESSURE_FIELD_NUMBER: _ClassVar[int]
    TEMPERATURE_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    WIND_FIELD_NUMBER: _ClassVar[int]
    city: str
    humidity: float
    pressure: float
    temperature: float
    type: WeatherType
    wind: float
    def __init__(self, city: _Optional[str] = ..., type: _Optional[_Union[WeatherType, str]] = ..., temperature: _Optional[float] = ..., humidity: _Optional[float] = ..., wind: _Optional[float] = ..., pressure: _Optional[float] = ...) -> None: ...

class WeatherTemperatureRequest(_message.Message):
    __slots__ = ["city", "range", "temperature"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    RANGE_FIELD_NUMBER: _ClassVar[int]
    TEMPERATURE_FIELD_NUMBER: _ClassVar[int]
    city: str
    range: float
    temperature: float
    def __init__(self, city: _Optional[str] = ..., temperature: _Optional[float] = ..., range: _Optional[float] = ...) -> None: ...

class WeatherTypeRequest(_message.Message):
    __slots__ = ["city", "type"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    city: str
    type: _containers.RepeatedScalarFieldContainer[WeatherType]
    def __init__(self, city: _Optional[str] = ..., type: _Optional[_Iterable[_Union[WeatherType, str]]] = ...) -> None: ...

class WeatherWindRequest(_message.Message):
    __slots__ = ["city", "range", "wind"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    RANGE_FIELD_NUMBER: _ClassVar[int]
    WIND_FIELD_NUMBER: _ClassVar[int]
    city: str
    range: float
    wind: float
    def __init__(self, city: _Optional[str] = ..., wind: _Optional[float] = ..., range: _Optional[float] = ...) -> None: ...

class WeatherType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

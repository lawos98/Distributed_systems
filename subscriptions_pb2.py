# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: subscriptions.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x13subscriptions.proto\x12\rsubscriptions\"\x90\x01\n\x0fWeatherResponse\x12\x0c\n\x04\x63ity\x18\x01 \x01(\t\x12(\n\x04type\x18\x02 \x01(\x0e\x32\x1a.subscriptions.WeatherType\x12\x13\n\x0btemperature\x18\x03 \x01(\x02\x12\x10\n\x08humidity\x18\x04 \x01(\x02\x12\x0c\n\x04wind\x18\x05 \x01(\x02\x12\x10\n\x08pressure\x18\x06 \x01(\x02\"M\n\x19WeatherTemperatureRequest\x12\x0c\n\x04\x63ity\x18\x01 \x01(\t\x12\x13\n\x0btemperature\x18\x02 \x01(\x02\x12\r\n\x05range\x18\x03 \x01(\x02\"G\n\x16WeatherHumidityRequest\x12\x0c\n\x04\x63ity\x18\x01 \x01(\t\x12\x10\n\x08humidity\x18\x02 \x01(\x02\x12\r\n\x05range\x18\x03 \x01(\x02\"?\n\x12WeatherWindRequest\x12\x0c\n\x04\x63ity\x18\x01 \x01(\t\x12\x0c\n\x04wind\x18\x02 \x01(\x02\x12\r\n\x05range\x18\x03 \x01(\x02\"G\n\x16WeatherPressureRequest\x12\x0c\n\x04\x63ity\x18\x01 \x01(\t\x12\x10\n\x08pressure\x18\x02 \x01(\x02\x12\r\n\x05range\x18\x03 \x01(\x02\"L\n\x12WeatherTypeRequest\x12\x0c\n\x04\x63ity\x18\x01 \x01(\t\x12(\n\x04type\x18\x02 \x03(\x0e\x32\x1a.subscriptions.WeatherType*R\n\x0bWeatherType\x12\t\n\x05SUNNY\x10\x00\x12\n\n\x06\x43LOUDY\x10\x01\x12\t\n\x05RAINY\x10\x02\x12\t\n\x05SNOWY\x10\x03\x12\x0b\n\x07THUNDER\x10\x04\x12\t\n\x05\x46OGGY\x10\x05\x32\xeb\x03\n\x0eWeatherService\x12\x65\n\x17GetWeatherByTemperature\x12(.subscriptions.WeatherTemperatureRequest\x1a\x1e.subscriptions.WeatherResponse0\x01\x12_\n\x14GetWeatherByHumidity\x12%.subscriptions.WeatherHumidityRequest\x1a\x1e.subscriptions.WeatherResponse0\x01\x12W\n\x10GetWeatherByWind\x12!.subscriptions.WeatherWindRequest\x1a\x1e.subscriptions.WeatherResponse0\x01\x12_\n\x14GetWeatherByPressure\x12%.subscriptions.WeatherPressureRequest\x1a\x1e.subscriptions.WeatherResponse0\x01\x12W\n\x10GetWeatherByType\x12!.subscriptions.WeatherTypeRequest\x1a\x1e.subscriptions.WeatherResponse0\x01\x62\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'subscriptions_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  _WEATHERTYPE._serialized_start=553
  _WEATHERTYPE._serialized_end=635
  _WEATHERRESPONSE._serialized_start=39
  _WEATHERRESPONSE._serialized_end=183
  _WEATHERTEMPERATUREREQUEST._serialized_start=185
  _WEATHERTEMPERATUREREQUEST._serialized_end=262
  _WEATHERHUMIDITYREQUEST._serialized_start=264
  _WEATHERHUMIDITYREQUEST._serialized_end=335
  _WEATHERWINDREQUEST._serialized_start=337
  _WEATHERWINDREQUEST._serialized_end=400
  _WEATHERPRESSUREREQUEST._serialized_start=402
  _WEATHERPRESSUREREQUEST._serialized_end=473
  _WEATHERTYPEREQUEST._serialized_start=475
  _WEATHERTYPEREQUEST._serialized_end=551
  _WEATHERSERVICE._serialized_start=638
  _WEATHERSERVICE._serialized_end=1129
# @@protoc_insertion_point(module_scope)

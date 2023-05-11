// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscriptions.proto

package proto;

/**
 * Protobuf type {@code subscriptions.WeatherTypeRequest}
 */
public final class WeatherTypeRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:subscriptions.WeatherTypeRequest)
    WeatherTypeRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WeatherTypeRequest.newBuilder() to construct.
  private WeatherTypeRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WeatherTypeRequest() {
    city_ = "";
    type_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WeatherTypeRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WeatherTypeRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            city_ = s;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              type_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            type_.add(rawValue);
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int oldLimit = input.pushLimit(length);
            while(input.getBytesUntilLimit() > 0) {
              int rawValue = input.readEnum();
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                type_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              type_.add(rawValue);
            }
            input.popLimit(oldLimit);
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        type_ = java.util.Collections.unmodifiableList(type_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.Subscriptions.internal_static_subscriptions_WeatherTypeRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.Subscriptions.internal_static_subscriptions_WeatherTypeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.WeatherTypeRequest.class, proto.WeatherTypeRequest.Builder.class);
  }

  public static final int CITY_FIELD_NUMBER = 1;
  private volatile java.lang.Object city_;
  /**
   * <code>string city = 1;</code>
   * @return The city.
   */
  @java.lang.Override
  public java.lang.String getCity() {
    java.lang.Object ref = city_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      city_ = s;
      return s;
    }
  }
  /**
   * <code>string city = 1;</code>
   * @return The bytes for city.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCityBytes() {
    java.lang.Object ref = city_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      city_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Integer> type_;
  private static final com.google.protobuf.Internal.ListAdapter.Converter<
      java.lang.Integer, proto.WeatherType> type_converter_ =
          new com.google.protobuf.Internal.ListAdapter.Converter<
              java.lang.Integer, proto.WeatherType>() {
            public proto.WeatherType convert(java.lang.Integer from) {
              @SuppressWarnings("deprecation")
              proto.WeatherType result = proto.WeatherType.valueOf(from);
              return result == null ? proto.WeatherType.UNRECOGNIZED : result;
            }
          };
  /**
   * <code>repeated .subscriptions.WeatherType type = 2;</code>
   * @return A list containing the type.
   */
  @java.lang.Override
  public java.util.List<proto.WeatherType> getTypeList() {
    return new com.google.protobuf.Internal.ListAdapter<
        java.lang.Integer, proto.WeatherType>(type_, type_converter_);
  }
  /**
   * <code>repeated .subscriptions.WeatherType type = 2;</code>
   * @return The count of type.
   */
  @java.lang.Override
  public int getTypeCount() {
    return type_.size();
  }
  /**
   * <code>repeated .subscriptions.WeatherType type = 2;</code>
   * @param index The index of the element to return.
   * @return The type at the given index.
   */
  @java.lang.Override
  public proto.WeatherType getType(int index) {
    return type_converter_.convert(type_.get(index));
  }
  /**
   * <code>repeated .subscriptions.WeatherType type = 2;</code>
   * @return A list containing the enum numeric values on the wire for type.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
  getTypeValueList() {
    return type_;
  }
  /**
   * <code>repeated .subscriptions.WeatherType type = 2;</code>
   * @param index The index of the value to return.
   * @return The enum numeric value on the wire of type at the given index.
   */
  @java.lang.Override
  public int getTypeValue(int index) {
    return type_.get(index);
  }
  private int typeMemoizedSerializedSize;

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(city_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, city_);
    }
    if (getTypeList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(typeMemoizedSerializedSize);
    }
    for (int i = 0; i < type_.size(); i++) {
      output.writeEnumNoTag(type_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(city_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, city_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < type_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeEnumSizeNoTag(type_.get(i));
      }
      size += dataSize;
      if (!getTypeList().isEmpty()) {  size += 1;
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32SizeNoTag(dataSize);
      }typeMemoizedSerializedSize = dataSize;
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof proto.WeatherTypeRequest)) {
      return super.equals(obj);
    }
    proto.WeatherTypeRequest other = (proto.WeatherTypeRequest) obj;

    if (!getCity()
        .equals(other.getCity())) return false;
    if (!type_.equals(other.type_)) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CITY_FIELD_NUMBER;
    hash = (53 * hash) + getCity().hashCode();
    if (getTypeCount() > 0) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_.hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static proto.WeatherTypeRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.WeatherTypeRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.WeatherTypeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.WeatherTypeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.WeatherTypeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.WeatherTypeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.WeatherTypeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proto.WeatherTypeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.WeatherTypeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static proto.WeatherTypeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.WeatherTypeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proto.WeatherTypeRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(proto.WeatherTypeRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code subscriptions.WeatherTypeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:subscriptions.WeatherTypeRequest)
      proto.WeatherTypeRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.Subscriptions.internal_static_subscriptions_WeatherTypeRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.Subscriptions.internal_static_subscriptions_WeatherTypeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.WeatherTypeRequest.class, proto.WeatherTypeRequest.Builder.class);
    }

    // Construct using proto.WeatherTypeRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      city_ = "";

      type_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.Subscriptions.internal_static_subscriptions_WeatherTypeRequest_descriptor;
    }

    @java.lang.Override
    public proto.WeatherTypeRequest getDefaultInstanceForType() {
      return proto.WeatherTypeRequest.getDefaultInstance();
    }

    @java.lang.Override
    public proto.WeatherTypeRequest build() {
      proto.WeatherTypeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.WeatherTypeRequest buildPartial() {
      proto.WeatherTypeRequest result = new proto.WeatherTypeRequest(this);
      int from_bitField0_ = bitField0_;
      result.city_ = city_;
      if (((bitField0_ & 0x00000001) != 0)) {
        type_ = java.util.Collections.unmodifiableList(type_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.type_ = type_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof proto.WeatherTypeRequest) {
        return mergeFrom((proto.WeatherTypeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(proto.WeatherTypeRequest other) {
      if (other == proto.WeatherTypeRequest.getDefaultInstance()) return this;
      if (!other.getCity().isEmpty()) {
        city_ = other.city_;
        onChanged();
      }
      if (!other.type_.isEmpty()) {
        if (type_.isEmpty()) {
          type_ = other.type_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureTypeIsMutable();
          type_.addAll(other.type_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      proto.WeatherTypeRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (proto.WeatherTypeRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object city_ = "";
    /**
     * <code>string city = 1;</code>
     * @return The city.
     */
    public java.lang.String getCity() {
      java.lang.Object ref = city_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        city_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string city = 1;</code>
     * @return The bytes for city.
     */
    public com.google.protobuf.ByteString
        getCityBytes() {
      java.lang.Object ref = city_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        city_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string city = 1;</code>
     * @param value The city to set.
     * @return This builder for chaining.
     */
    public Builder setCity(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      city_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string city = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCity() {
      
      city_ = getDefaultInstance().getCity();
      onChanged();
      return this;
    }
    /**
     * <code>string city = 1;</code>
     * @param value The bytes for city to set.
     * @return This builder for chaining.
     */
    public Builder setCityBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      city_ = value;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> type_ =
      java.util.Collections.emptyList();
    private void ensureTypeIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        type_ = new java.util.ArrayList<java.lang.Integer>(type_);
        bitField0_ |= 0x00000001;
      }
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @return A list containing the type.
     */
    public java.util.List<proto.WeatherType> getTypeList() {
      return new com.google.protobuf.Internal.ListAdapter<
          java.lang.Integer, proto.WeatherType>(type_, type_converter_);
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @return The count of type.
     */
    public int getTypeCount() {
      return type_.size();
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param index The index of the element to return.
     * @return The type at the given index.
     */
    public proto.WeatherType getType(int index) {
      return type_converter_.convert(type_.get(index));
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param index The index to set the value at.
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(
        int index, proto.WeatherType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureTypeIsMutable();
      type_.set(index, value.getNumber());
      onChanged();
      return this;
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param value The type to add.
     * @return This builder for chaining.
     */
    public Builder addType(proto.WeatherType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureTypeIsMutable();
      type_.add(value.getNumber());
      onChanged();
      return this;
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param values The type to add.
     * @return This builder for chaining.
     */
    public Builder addAllType(
        java.lang.Iterable<? extends proto.WeatherType> values) {
      ensureTypeIsMutable();
      for (proto.WeatherType value : values) {
        type_.add(value.getNumber());
      }
      onChanged();
      return this;
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      type_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @return A list containing the enum numeric values on the wire for type.
     */
    public java.util.List<java.lang.Integer>
    getTypeValueList() {
      return java.util.Collections.unmodifiableList(type_);
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param index The index of the value to return.
     * @return The enum numeric value on the wire of type at the given index.
     */
    public int getTypeValue(int index) {
      return type_.get(index);
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param index The index of the value to return.
     * @return The enum numeric value on the wire of type at the given index.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(
        int index, int value) {
      ensureTypeIsMutable();
      type_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param value The enum numeric value on the wire for type to add.
     * @return This builder for chaining.
     */
    public Builder addTypeValue(int value) {
      ensureTypeIsMutable();
      type_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .subscriptions.WeatherType type = 2;</code>
     * @param values The enum numeric values on the wire for type to add.
     * @return This builder for chaining.
     */
    public Builder addAllTypeValue(
        java.lang.Iterable<java.lang.Integer> values) {
      ensureTypeIsMutable();
      for (int value : values) {
        type_.add(value);
      }
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:subscriptions.WeatherTypeRequest)
  }

  // @@protoc_insertion_point(class_scope:subscriptions.WeatherTypeRequest)
  private static final proto.WeatherTypeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.WeatherTypeRequest();
  }

  public static proto.WeatherTypeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WeatherTypeRequest>
      PARSER = new com.google.protobuf.AbstractParser<WeatherTypeRequest>() {
    @java.lang.Override
    public WeatherTypeRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WeatherTypeRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WeatherTypeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WeatherTypeRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.WeatherTypeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


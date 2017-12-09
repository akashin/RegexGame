// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game_action.proto

package com.regexgame;

/**
 * Protobuf type {@code regexgame.AttackCard}
 */
public  final class AttackCard extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:regexgame.AttackCard)
    AttackCardOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AttackCard.newBuilder() to construct.
  private AttackCard(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AttackCard() {
    attackerCards_ = java.util.Collections.emptyList();
    attackedCard_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AttackCard(
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
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              attackerCards_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            attackerCards_.add(input.readInt32());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              attackerCards_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              attackerCards_.add(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
          case 16: {

            attackedCard_ = input.readInt32();
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        attackerCards_ = java.util.Collections.unmodifiableList(attackerCards_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.regexgame.GameActionOuterClass.internal_static_regexgame_AttackCard_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.regexgame.GameActionOuterClass.internal_static_regexgame_AttackCard_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.regexgame.AttackCard.class, com.regexgame.AttackCard.Builder.class);
  }

  private int bitField0_;
  public static final int ATTACKER_CARDS_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Integer> attackerCards_;
  /**
   * <code>repeated int32 attacker_cards = 1;</code>
   */
  public java.util.List<java.lang.Integer>
      getAttackerCardsList() {
    return attackerCards_;
  }
  /**
   * <code>repeated int32 attacker_cards = 1;</code>
   */
  public int getAttackerCardsCount() {
    return attackerCards_.size();
  }
  /**
   * <code>repeated int32 attacker_cards = 1;</code>
   */
  public int getAttackerCards(int index) {
    return attackerCards_.get(index);
  }
  private int attackerCardsMemoizedSerializedSize = -1;

  public static final int ATTACKED_CARD_FIELD_NUMBER = 2;
  private int attackedCard_;
  /**
   * <code>int32 attacked_card = 2;</code>
   */
  public int getAttackedCard() {
    return attackedCard_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (getAttackerCardsList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(attackerCardsMemoizedSerializedSize);
    }
    for (int i = 0; i < attackerCards_.size(); i++) {
      output.writeInt32NoTag(attackerCards_.get(i));
    }
    if (attackedCard_ != 0) {
      output.writeInt32(2, attackedCard_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < attackerCards_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(attackerCards_.get(i));
      }
      size += dataSize;
      if (!getAttackerCardsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      attackerCardsMemoizedSerializedSize = dataSize;
    }
    if (attackedCard_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, attackedCard_);
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
    if (!(obj instanceof com.regexgame.AttackCard)) {
      return super.equals(obj);
    }
    com.regexgame.AttackCard other = (com.regexgame.AttackCard) obj;

    boolean result = true;
    result = result && getAttackerCardsList()
        .equals(other.getAttackerCardsList());
    result = result && (getAttackedCard()
        == other.getAttackedCard());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getAttackerCardsCount() > 0) {
      hash = (37 * hash) + ATTACKER_CARDS_FIELD_NUMBER;
      hash = (53 * hash) + getAttackerCardsList().hashCode();
    }
    hash = (37 * hash) + ATTACKED_CARD_FIELD_NUMBER;
    hash = (53 * hash) + getAttackedCard();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.regexgame.AttackCard parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.regexgame.AttackCard parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.regexgame.AttackCard parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.regexgame.AttackCard parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.regexgame.AttackCard parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.regexgame.AttackCard parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.regexgame.AttackCard parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.regexgame.AttackCard parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.regexgame.AttackCard parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.regexgame.AttackCard parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.regexgame.AttackCard parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.regexgame.AttackCard parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.regexgame.AttackCard prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code regexgame.AttackCard}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:regexgame.AttackCard)
      com.regexgame.AttackCardOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.regexgame.GameActionOuterClass.internal_static_regexgame_AttackCard_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.regexgame.GameActionOuterClass.internal_static_regexgame_AttackCard_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.regexgame.AttackCard.class, com.regexgame.AttackCard.Builder.class);
    }

    // Construct using com.regexgame.AttackCard.newBuilder()
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
    public Builder clear() {
      super.clear();
      attackerCards_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      attackedCard_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.regexgame.GameActionOuterClass.internal_static_regexgame_AttackCard_descriptor;
    }

    public com.regexgame.AttackCard getDefaultInstanceForType() {
      return com.regexgame.AttackCard.getDefaultInstance();
    }

    public com.regexgame.AttackCard build() {
      com.regexgame.AttackCard result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.regexgame.AttackCard buildPartial() {
      com.regexgame.AttackCard result = new com.regexgame.AttackCard(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        attackerCards_ = java.util.Collections.unmodifiableList(attackerCards_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.attackerCards_ = attackerCards_;
      result.attackedCard_ = attackedCard_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.regexgame.AttackCard) {
        return mergeFrom((com.regexgame.AttackCard)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.regexgame.AttackCard other) {
      if (other == com.regexgame.AttackCard.getDefaultInstance()) return this;
      if (!other.attackerCards_.isEmpty()) {
        if (attackerCards_.isEmpty()) {
          attackerCards_ = other.attackerCards_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureAttackerCardsIsMutable();
          attackerCards_.addAll(other.attackerCards_);
        }
        onChanged();
      }
      if (other.getAttackedCard() != 0) {
        setAttackedCard(other.getAttackedCard());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.regexgame.AttackCard parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.regexgame.AttackCard) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Integer> attackerCards_ = java.util.Collections.emptyList();
    private void ensureAttackerCardsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        attackerCards_ = new java.util.ArrayList<java.lang.Integer>(attackerCards_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 attacker_cards = 1;</code>
     */
    public java.util.List<java.lang.Integer>
        getAttackerCardsList() {
      return java.util.Collections.unmodifiableList(attackerCards_);
    }
    /**
     * <code>repeated int32 attacker_cards = 1;</code>
     */
    public int getAttackerCardsCount() {
      return attackerCards_.size();
    }
    /**
     * <code>repeated int32 attacker_cards = 1;</code>
     */
    public int getAttackerCards(int index) {
      return attackerCards_.get(index);
    }
    /**
     * <code>repeated int32 attacker_cards = 1;</code>
     */
    public Builder setAttackerCards(
        int index, int value) {
      ensureAttackerCardsIsMutable();
      attackerCards_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 attacker_cards = 1;</code>
     */
    public Builder addAttackerCards(int value) {
      ensureAttackerCardsIsMutable();
      attackerCards_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 attacker_cards = 1;</code>
     */
    public Builder addAllAttackerCards(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureAttackerCardsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, attackerCards_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 attacker_cards = 1;</code>
     */
    public Builder clearAttackerCards() {
      attackerCards_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private int attackedCard_ ;
    /**
     * <code>int32 attacked_card = 2;</code>
     */
    public int getAttackedCard() {
      return attackedCard_;
    }
    /**
     * <code>int32 attacked_card = 2;</code>
     */
    public Builder setAttackedCard(int value) {
      
      attackedCard_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 attacked_card = 2;</code>
     */
    public Builder clearAttackedCard() {
      
      attackedCard_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:regexgame.AttackCard)
  }

  // @@protoc_insertion_point(class_scope:regexgame.AttackCard)
  private static final com.regexgame.AttackCard DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.regexgame.AttackCard();
  }

  public static com.regexgame.AttackCard getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AttackCard>
      PARSER = new com.google.protobuf.AbstractParser<AttackCard>() {
    public AttackCard parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AttackCard(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AttackCard> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AttackCard> getParserForType() {
    return PARSER;
  }

  public com.regexgame.AttackCard getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

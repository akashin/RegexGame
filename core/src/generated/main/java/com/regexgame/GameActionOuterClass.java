// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game_action.proto

package com.regexgame;

public final class GameActionOuterClass {
  private GameActionOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_GameAction_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_GameAction_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_IncreaseNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_IncreaseNumber_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_DecreaseNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_DecreaseNumber_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021game_action.proto\022\tregexgame\"\202\001\n\nGameA" +
      "ction\0224\n\017increase_number\030\001 \001(\0132\031.regexga" +
      "me.IncreaseNumberH\000\0224\n\017decrease_number\030\002" +
      " \001(\0132\031.regexgame.DecreaseNumberH\000B\010\n\006act" +
      "ion\"\020\n\016IncreaseNumber\"\020\n\016DecreaseNumberB" +
      "\027\n\rcom.regexgameP\001\242\002\003HLWb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_regexgame_GameAction_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_regexgame_GameAction_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_GameAction_descriptor,
        new java.lang.String[] { "IncreaseNumber", "DecreaseNumber", "Action", });
    internal_static_regexgame_IncreaseNumber_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_regexgame_IncreaseNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_IncreaseNumber_descriptor,
        new java.lang.String[] { });
    internal_static_regexgame_DecreaseNumber_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_regexgame_DecreaseNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_DecreaseNumber_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
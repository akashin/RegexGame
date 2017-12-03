// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game_service.proto

package com.regexgame;

public final class GameService {
  private GameService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_CreateMatchRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_CreateMatchRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_CreateMatchReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_CreateMatchReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_GetEventsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_GetEventsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_MakeActionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_MakeActionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_MakeActionReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_MakeActionReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_GetMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_GetMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_regexgame_GetMessageReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_regexgame_GetMessageReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022game_service.proto\022\tregexgame\032\020game_ev" +
      "ent.proto\032\021game_action.proto\"\024\n\022CreateMa" +
      "tchRequest\"$\n\020CreateMatchReply\022\020\n\010match_" +
      "id\030\001 \001(\003\"=\n\020GetEventsRequest\022\020\n\010match_id" +
      "\030\001 \001(\003\022\027\n\017start_timestamp\030\002 \001(\005\"L\n\021MakeA" +
      "ctionRequest\022\020\n\010match_id\030\001 \001(\003\022%\n\006action" +
      "\030\002 \001(\0132\025.regexgame.GameAction\"\021\n\017MakeAct" +
      "ionReply\"!\n\021GetMessageRequest\022\014\n\004name\030\001 " +
      "\001(\t\"\"\n\017GetMessageReply\022\017\n\007message\030\001 \001(\t2" +
      "\260\002\n\tRegexGame\022H\n\nGetMessage\022\034.regexgame." +
      "GetMessageRequest\032\032.regexgame.GetMessage" +
      "Reply\"\000\022K\n\013CreateMatch\022\035.regexgame.Creat" +
      "eMatchRequest\032\033.regexgame.CreateMatchRep" +
      "ly\"\000\022B\n\tGetEvents\022\033.regexgame.GetEventsR" +
      "equest\032\024.regexgame.GameEvent\"\0000\001\022H\n\nMake" +
      "Action\022\034.regexgame.MakeActionRequest\032\032.r" +
      "egexgame.MakeActionReply\"\000B\027\n\rcom.regexg" +
      "ameP\001\242\002\003HLWb\006proto3"
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
          com.regexgame.GameEventOuterClass.getDescriptor(),
          com.regexgame.GameActionOuterClass.getDescriptor(),
        }, assigner);
    internal_static_regexgame_CreateMatchRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_regexgame_CreateMatchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_CreateMatchRequest_descriptor,
        new java.lang.String[] { });
    internal_static_regexgame_CreateMatchReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_regexgame_CreateMatchReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_CreateMatchReply_descriptor,
        new java.lang.String[] { "MatchId", });
    internal_static_regexgame_GetEventsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_regexgame_GetEventsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_GetEventsRequest_descriptor,
        new java.lang.String[] { "MatchId", "StartTimestamp", });
    internal_static_regexgame_MakeActionRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_regexgame_MakeActionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_MakeActionRequest_descriptor,
        new java.lang.String[] { "MatchId", "Action", });
    internal_static_regexgame_MakeActionReply_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_regexgame_MakeActionReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_MakeActionReply_descriptor,
        new java.lang.String[] { });
    internal_static_regexgame_GetMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_regexgame_GetMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_GetMessageRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_regexgame_GetMessageReply_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_regexgame_GetMessageReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_regexgame_GetMessageReply_descriptor,
        new java.lang.String[] { "Message", });
    com.regexgame.GameEventOuterClass.getDescriptor();
    com.regexgame.GameActionOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

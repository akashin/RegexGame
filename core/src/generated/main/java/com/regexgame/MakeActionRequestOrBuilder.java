// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game_service.proto

package com.regexgame;

public interface MakeActionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:regexgame.MakeActionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 match_id = 1;</code>
   */
  long getMatchId();

  /**
   * <code>.regexgame.GameAction action = 2;</code>
   */
  boolean hasAction();
  /**
   * <code>.regexgame.GameAction action = 2;</code>
   */
  com.regexgame.GameAction getAction();
  /**
   * <code>.regexgame.GameAction action = 2;</code>
   */
  com.regexgame.GameActionOrBuilder getActionOrBuilder();
}
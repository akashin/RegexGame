// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game_action.proto

package com.regexgame;

public interface AttackCardOrBuilder extends
    // @@protoc_insertion_point(interface_extends:regexgame.AttackCard)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated int32 attacker_cards = 1;</code>
   */
  java.util.List<java.lang.Integer> getAttackerCardsList();
  /**
   * <code>repeated int32 attacker_cards = 1;</code>
   */
  int getAttackerCardsCount();
  /**
   * <code>repeated int32 attacker_cards = 1;</code>
   */
  int getAttackerCards(int index);

  /**
   * <code>int32 attacked_card = 2;</code>
   */
  int getAttackedCard();
}
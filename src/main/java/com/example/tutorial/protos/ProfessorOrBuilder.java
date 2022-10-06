// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test.proto

package com.example.tutorial.protos;

public interface ProfessorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tutorial.Professor)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string name = 1;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>optional string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional string id = 2;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>optional string id = 2;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>optional string id = 2;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>optional string email = 3;</code>
   * @return Whether the email field is set.
   */
  boolean hasEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>optional string birthDate = 4;</code>
   * @return Whether the birthDate field is set.
   */
  boolean hasBirthDate();
  /**
   * <code>optional string birthDate = 4;</code>
   * @return The birthDate.
   */
  java.lang.String getBirthDate();
  /**
   * <code>optional string birthDate = 4;</code>
   * @return The bytes for birthDate.
   */
  com.google.protobuf.ByteString
      getBirthDateBytes();

  /**
   * <code>optional string phoneNumber = 5;</code>
   * @return Whether the phoneNumber field is set.
   */
  boolean hasPhoneNumber();
  /**
   * <code>optional string phoneNumber = 5;</code>
   * @return The phoneNumber.
   */
  java.lang.String getPhoneNumber();
  /**
   * <code>optional string phoneNumber = 5;</code>
   * @return The bytes for phoneNumber.
   */
  com.google.protobuf.ByteString
      getPhoneNumberBytes();

  /**
   * <code>optional string address = 6;</code>
   * @return Whether the address field is set.
   */
  boolean hasAddress();
  /**
   * <code>optional string address = 6;</code>
   * @return The address.
   */
  java.lang.String getAddress();
  /**
   * <code>optional string address = 6;</code>
   * @return The bytes for address.
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <code>repeated .tutorial.Student student = 7;</code>
   */
  java.util.List<com.example.tutorial.protos.Student> 
      getStudentList();
  /**
   * <code>repeated .tutorial.Student student = 7;</code>
   */
  com.example.tutorial.protos.Student getStudent(int index);
  /**
   * <code>repeated .tutorial.Student student = 7;</code>
   */
  int getStudentCount();
  /**
   * <code>repeated .tutorial.Student student = 7;</code>
   */
  java.util.List<? extends com.example.tutorial.protos.StudentOrBuilder> 
      getStudentOrBuilderList();
  /**
   * <code>repeated .tutorial.Student student = 7;</code>
   */
  com.example.tutorial.protos.StudentOrBuilder getStudentOrBuilder(
      int index);
}
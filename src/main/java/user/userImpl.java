// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package user;

public final class userImpl {
  private userImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_LoginMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_LoginMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_LogOutMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_LogOutMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_EmptyMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_EmptyMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nuser.proto\022\004user\"2\n\014LoginRequest\022\020\n\010us" +
      "erName\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"\037\n\014LoginM" +
      "essage\022\017\n\007message\030\001 \001(\t\" \n\rLogOutMessage" +
      "\022\017\n\007message\030\001 \001(\t\"\016\n\014EmptyMessage2v\n\004use" +
      "r\0225\n\tuserLogin\022\022.user.LoginRequest\032\022.use" +
      "r.LoginMessage\"\000\0227\n\nuserLogout\022\022.user.Em" +
      "ptyMessage\032\023.user.LogOutMessage\"\000B\022\n\004use" +
      "rB\010userImplP\001b\006proto3"
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
    internal_static_user_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_user_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_LoginRequest_descriptor,
        new java.lang.String[] { "UserName", "Password", });
    internal_static_user_LoginMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_user_LoginMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_LoginMessage_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_user_LogOutMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_user_LogOutMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_LogOutMessage_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_user_EmptyMessage_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_user_EmptyMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_EmptyMessage_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
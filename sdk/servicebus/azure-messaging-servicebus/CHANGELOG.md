# Release History

## 7.0.0-beta.8 (Unreleased)


## 7.0.0-beta.7 (2020-11-06)
### New Features
- Added automatic message and session lock renewal feature on the receiver clients. By default, this will be done 
  for 5 minutes.
- Added auto complete feature to the async receiver clients. Once the client completes executing the user provided 
  callback for a message, the message will be completed. If the user provided callback throws an error, the message 
  will be abandoned. This feature is enabled by default and can be disabled by calling `disableAutoComplete()` on 
  builder. 
- An intermediate `ServiceBusSessionReceiverClient` is introduced to act as the factory which can then be used to accept 
  sessions from the service. Accepting a session would give you the familiar receiver client tied to a single session.
- Added `ServiceBusProcessorClient` which takes your callbacks to process messages and errors in an infinite loop. This 
  also supports working with sessions where you can provide the maximum number of sessions to work with concurrently. 
  When the client no longer receives any messages from one session, it rolls over to the next available session.
- Added `BinaryData` in `ServiceBusReceivedMessage` and `ServiceBusMessage`. `BinaryData` is convenience wrapper over
  byte array and provides object serialization functionality.
- Added `ServicebusReceiverException` and `ServiceBusErrorSource` to provide better handling of errors while receiving 
  messages.

### Breaking Changes
- Changed `receiveMessages` API to return `ServiceBusReceivedMessage` instead of ServiceBusReceivedMessageContext in 
  `ServiceBusReceiverAsynClient` and `ServiceBusReceiverClient`.
- Removed `SendVia` option from `ServiceBusClientBuilder`. See issue for more detail 
  [16942](https://github.com/Azure/azure-sdk-for-java/pull/16942).
- Removed `sessionId` setting from `ServiceBusSessionReceiverClientBuilder` as creating receiver clients bound to a 
  single session is now a feature in the new intermediate clients `ServiceBusSessionReceiverClient` and 
  `ServiceBusSessionReceiverAsyncClient`.
- Moved the `maxConcurrentSessions` setting from `ServiceBusSessionReceiverClientBuilder` to 
  `ServiceBusSessionProcessorClientBuilder` as the feature of receiving messages from multiple sessions is moved from 
  the receiver client to the new `ServiceBusSessionProcessorClient`.
- Renamed `tryAdd` to `tryAddMessage` in `ServiceBusMessageBatch`.
- Removed `sessionId` specific methods from `ServiceBusReceiverAsynClient` and `ServiceBusReceiverClient` because now 
  receiver client is always tied to one session. 
  
### Bug Fixes
- `ServiceBusAdministrationClient`: Fixes serialization bug for creating and deserializing rules.

### Dependency Updates
- Added new `azure-core-experimental` dependency with version `1.0.0-beta.8`.
- Upgraded `azure-core` dependency to `1.10.0`.
- Upgraded `azure-core-amqp` dependency to `1.7.0-beta.1`.

## 7.0.0-beta.6 (2020-09-11)
- Add Amqp Message envelope in form of `AmqpAnnotatedMessage` as a property of `ServiceBusReceivedMessage` and
  `ServiceBusMessage`.
- Remove `ServiceBusReceiverClientBuilder.maxAutoLockRenewalDuration`. Use method `renewMessageLock` and
  `renewSessionLock` of classes `ServiceBusReceiverClient` and `ServiceBusReceiverAsyncClient` to lock messages and
  sessions.
- Update datetime related APIs to use `java.time.OffsetDateTime` instead of `java.time.Instant`.
- Remove `scheduledMessageCount` from `SubscriptionRuntimeInfo` and added it to `TopicRuntimeInfo`.
- Change `QueueRuntimeInfo`, `TopicRuntimeInfo` and `SubscriptionRuntimeInfo` to `QueueRuntimeProperties`,
  `TopicRuntimeProperties` and `SubscriptionRuntimeProperties` respectively.
- Add ability to authenticate using SAS.
- Add support for `AuthorizationRules` during management operations.
- Rename `ServiceBusManagementClient` to `ServiceBusAdministrationClient`.
- Remove `ServiceBusDeadletterReceiverBuilder` and replaced with `SubQueue` type to access transfer deadletter and 
  deadletter queue.
- Remove settlement operations that take `String lockToken`, replaced with `ServiceBusReceivedMessage`.

## 7.0.0-beta.5 (2020-08-11)
- Remove public constructor for QueueDescription, TopicDescription, SubscriptionDescription.
- Expose CreateQueueOptions, CreateTopicOptions, CreateSubscriptionOptions to create entities.
- Flatten and remove MessageCountDetails in QueueRuntimeInfo, TopicRuntimeInfo, and SubscriptionRuntimeInfo.
- Limiting visibility of properties on QueueDescription, TopicDescription, SubscriptionDescription to only those that
  can be updated.
- Added a short timeout of 1 second in between messages for sync receive only.

## 7.0.0-beta.4 (2020-07-10)
- Add support for send messages via another entity.
- Add support for management operations on a topic, subscription, or namespace.
- Add support for receiving messages from the dead letter queue.
- Change suffixes for receive methods by adding `Message` or `Messages`.
- Remove `MessageLockToken` interface in favour of passing a lock token string.

## 7.0.0-beta.3 (2020-06-08)
- Add support for transaction feature in all the clients.
- Add support for management operations on a Queue.

## 7.0.0-beta.2 (2020-05-07)

- Add support for receiving messages from specific sessions
- Add support for receiving messages from multiple sessions
- Add missing schedule and cancel APIs in ServiceBusSenderClient
- Add support to send a collection of messages at once without needing to create a `ServiceBusMessageBatch` first. This
  will throw an error/exception will the messages cannot fit as per batch size restrictions
- Change return type from `ServiceBusReceivedMessage` to `ServiceBusReceivedMessageContext` when calling `receive()` so
  users can distinguish between transient failure scenarios where receiving continues and an actual terminal signal that
  is signaled through the downstream `onError`.
- Fix message settlement to occur on receive link
- Fix issue where backpressure is not properly supported

## 7.0.0-beta.1 (2020-04-06)

Version 7.0.0-beta.1 is a beta of our efforts in creating a client library that is developer-friendly, idiomatic
to the Java ecosystem, and as consistent across different languages and platforms as possible. The principles that guide
our efforts can be found in the [Azure SDK Design Guidelines for
.Java](https://azuresdkspecs.z5.web.core.windows.net/JavaSpec.html).

### Features

- Reactive streams support using [Project Reactor](https://projectreactor.io/).
- Send messages to an Azure Service Bus Topic or Queue.
- Receive messages from an Azure Service Bus Queue or Subscriber.

### Known issues

- Following features are not implemented Transactions, Sessions, Managing filter rules on Subscription.

![Impressions](https://azure-sdk-impressions.azurewebsites.net/api/impressions/azure-sdk-for-java%2Fsdk%2Fservicebus%2Fazure-messaging-servicebus%2FCHANGELOG.png)

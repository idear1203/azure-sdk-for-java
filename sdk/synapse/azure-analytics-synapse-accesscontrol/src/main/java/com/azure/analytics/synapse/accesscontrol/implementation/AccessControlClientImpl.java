// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.accesscontrol.implementation;

import com.azure.analytics.synapse.accesscontrol.models.ErrorContractException;
import com.azure.analytics.synapse.accesscontrol.models.GetRoleAssignmentsResponse;
import com.azure.analytics.synapse.accesscontrol.models.RoleAssignmentDetails;
import com.azure.analytics.synapse.accesscontrol.models.RoleAssignmentOptions;
import com.azure.analytics.synapse.accesscontrol.models.RolesListResponse;
import com.azure.analytics.synapse.accesscontrol.models.SynapseRole;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import java.util.List;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the AccessControlClient type. */
public final class AccessControlClientImpl {
    /** The proxy service used to perform REST calls. */
    private final AccessControlClientService service;

    /** The workspace development endpoint, for example https://myworkspace.dev.azuresynapse.net. */
    private final String endpoint;

    /**
     * Gets The workspace development endpoint, for example https://myworkspace.dev.azuresynapse.net.
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /** Api Version. */
    private final String apiVersion;

    /**
     * Gets Api Version.
     *
     * @return the apiVersion value.
     */
    public String getApiVersion() {
        return this.apiVersion;
    }

    /** The HTTP pipeline to send requests through. */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /** The serializer to serialize an object into a string. */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     *
     * @return the serializerAdapter value.
     */
    public SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /** Initializes an instance of AccessControlClient client. */
    public AccessControlClientImpl(String endpoint) {
        this(
                new HttpPipelineBuilder()
                        .policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy())
                        .build(),
                JacksonAdapter.createDefaultSerializerAdapter(),
                endpoint);
    }

    /**
     * Initializes an instance of AccessControlClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     */
    public AccessControlClientImpl(HttpPipeline httpPipeline, String endpoint) {
        this(httpPipeline, JacksonAdapter.createDefaultSerializerAdapter(), endpoint);
    }

    /**
     * Initializes an instance of AccessControlClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     */
    public AccessControlClientImpl(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.endpoint = endpoint;
        this.apiVersion = "2020-02-01-preview";
        this.service =
                RestProxy.create(AccessControlClientService.class, this.httpPipeline, this.getSerializerAdapter());
    }

    /**
     * The interface defining all the services for AccessControlClient to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "AccessControlClient")
    private interface AccessControlClientService {
        @Post("/rbac/roleAssignments")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<Response<RoleAssignmentDetails>> createRoleAssignment(
                @HostParam("endpoint") String endpoint,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/json") RoleAssignmentOptions createRoleAssignmentOptions,
                Context context);

        @Get("/rbac/roleAssignments")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<GetRoleAssignmentsResponse> getRoleAssignments(
                @HostParam("endpoint") String endpoint,
                @QueryParam("api-version") String apiVersion,
                @QueryParam("roleId") String roleId,
                @QueryParam("principalId") String principalId,
                @HeaderParam("x-ms-continuation") String continuationToken,
                Context context);

        @Get("/rbac/roleAssignments/{roleAssignmentId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<Response<RoleAssignmentDetails>> getRoleAssignmentById(
                @HostParam("endpoint") String endpoint,
                @PathParam("roleAssignmentId") String roleAssignmentId,
                @QueryParam("api-version") String apiVersion,
                Context context);

        @Delete("/rbac/roleAssignments/{roleAssignmentId}")
        @ExpectedResponses({200, 204})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<Response<Void>> deleteRoleAssignmentById(
                @HostParam("endpoint") String endpoint,
                @PathParam("roleAssignmentId") String roleAssignmentId,
                @QueryParam("api-version") String apiVersion,
                Context context);

        @Post("/rbac/getMyAssignedRoles")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<Response<List<String>>> getCallerRoleAssignments(
                @HostParam("endpoint") String endpoint, @QueryParam("api-version") String apiVersion, Context context);

        @Get("/rbac/roles")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<Response<RolesListResponse>> getRoleDefinitions(
                @HostParam("endpoint") String endpoint, @QueryParam("api-version") String apiVersion, Context context);

        @Get("/rbac/roles/{roleId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<Response<SynapseRole>> getRoleDefinitionById(
                @HostParam("endpoint") String endpoint,
                @PathParam("roleId") String roleId,
                @QueryParam("api-version") String apiVersion,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorContractException.class)
        Mono<Response<RolesListResponse>> getRoleDefinitionsNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink, Context context);
    }

    /**
     * Create role assignment.
     *
     * @param createRoleAssignmentOptions Role Assignment request details.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role Assignment response details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RoleAssignmentDetails>> createRoleAssignmentWithResponseAsync(
            RoleAssignmentOptions createRoleAssignmentOptions) {
        return FluxUtil.withContext(
                context ->
                        service.createRoleAssignment(
                                this.getEndpoint(), this.getApiVersion(), createRoleAssignmentOptions, context));
    }

    /**
     * Create role assignment.
     *
     * @param createRoleAssignmentOptions Role Assignment request details.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role Assignment response details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RoleAssignmentDetails> createRoleAssignmentAsync(RoleAssignmentOptions createRoleAssignmentOptions) {
        return createRoleAssignmentWithResponseAsync(createRoleAssignmentOptions)
                .flatMap(
                        (Response<RoleAssignmentDetails> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Create role assignment.
     *
     * @param createRoleAssignmentOptions Role Assignment request details.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role Assignment response details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RoleAssignmentDetails createRoleAssignment(RoleAssignmentOptions createRoleAssignmentOptions) {
        return createRoleAssignmentAsync(createRoleAssignmentOptions).block();
    }

    /**
     * List role assignments.
     *
     * @param roleId Synapse Built-In Role Id.
     * @param principalId Object ID of the AAD principal or security-group.
     * @param continuationToken Continuation token.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of role assignments.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<GetRoleAssignmentsResponse> getRoleAssignmentsWithResponseAsync(
            String roleId, String principalId, String continuationToken) {
        return FluxUtil.withContext(
                context ->
                        service.getRoleAssignments(
                                this.getEndpoint(),
                                this.getApiVersion(),
                                roleId,
                                principalId,
                                continuationToken,
                                context));
    }

    /**
     * List role assignments.
     *
     * @param roleId Synapse Built-In Role Id.
     * @param principalId Object ID of the AAD principal or security-group.
     * @param continuationToken Continuation token.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of role assignments.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<RoleAssignmentDetails>> getRoleAssignmentsAsync(
            String roleId, String principalId, String continuationToken) {
        return getRoleAssignmentsWithResponseAsync(roleId, principalId, continuationToken)
                .flatMap(
                        (GetRoleAssignmentsResponse res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * List role assignments.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of role assignments.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<RoleAssignmentDetails>> getRoleAssignmentsAsync() {
        final String roleId = null;
        final String principalId = null;
        final String continuationToken = null;
        final Context context = null;
        return getRoleAssignmentsWithResponseAsync(roleId, principalId, continuationToken)
                .flatMap(
                        (GetRoleAssignmentsResponse res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * List role assignments.
     *
     * @param roleId Synapse Built-In Role Id.
     * @param principalId Object ID of the AAD principal or security-group.
     * @param continuationToken Continuation token.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of role assignments.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<RoleAssignmentDetails> getRoleAssignments(String roleId, String principalId, String continuationToken) {
        return getRoleAssignmentsAsync(roleId, principalId, continuationToken).block();
    }

    /**
     * List role assignments.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of role assignments.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<RoleAssignmentDetails> getRoleAssignments() {
        final String roleId = null;
        final String principalId = null;
        final String continuationToken = null;
        final Context context = null;
        return getRoleAssignmentsAsync(roleId, principalId, continuationToken).block();
    }

    /**
     * Get role assignment by role assignment Id.
     *
     * @param roleAssignmentId The ID of the role assignment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role assignment by role assignment Id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RoleAssignmentDetails>> getRoleAssignmentByIdWithResponseAsync(String roleAssignmentId) {
        return FluxUtil.withContext(
                context ->
                        service.getRoleAssignmentById(
                                this.getEndpoint(), roleAssignmentId, this.getApiVersion(), context));
    }

    /**
     * Get role assignment by role assignment Id.
     *
     * @param roleAssignmentId The ID of the role assignment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role assignment by role assignment Id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RoleAssignmentDetails> getRoleAssignmentByIdAsync(String roleAssignmentId) {
        return getRoleAssignmentByIdWithResponseAsync(roleAssignmentId)
                .flatMap(
                        (Response<RoleAssignmentDetails> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Get role assignment by role assignment Id.
     *
     * @param roleAssignmentId The ID of the role assignment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role assignment by role assignment Id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RoleAssignmentDetails getRoleAssignmentById(String roleAssignmentId) {
        return getRoleAssignmentByIdAsync(roleAssignmentId).block();
    }

    /**
     * Delete role assignment by role assignment Id.
     *
     * @param roleAssignmentId The ID of the role assignment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteRoleAssignmentByIdWithResponseAsync(String roleAssignmentId) {
        return FluxUtil.withContext(
                context ->
                        service.deleteRoleAssignmentById(
                                this.getEndpoint(), roleAssignmentId, this.getApiVersion(), context));
    }

    /**
     * Delete role assignment by role assignment Id.
     *
     * @param roleAssignmentId The ID of the role assignment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteRoleAssignmentByIdAsync(String roleAssignmentId) {
        return deleteRoleAssignmentByIdWithResponseAsync(roleAssignmentId)
                .flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Delete role assignment by role assignment Id.
     *
     * @param roleAssignmentId The ID of the role assignment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteRoleAssignmentById(String roleAssignmentId) {
        deleteRoleAssignmentByIdAsync(roleAssignmentId).block();
    }

    /**
     * List role assignments of the caller.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of Post200ApplicationJsonItemsItem.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<List<String>>> getCallerRoleAssignmentsWithResponseAsync() {
        return FluxUtil.withContext(
                context -> service.getCallerRoleAssignments(this.getEndpoint(), this.getApiVersion(), context));
    }

    /**
     * List role assignments of the caller.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of Post200ApplicationJsonItemsItem.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<String>> getCallerRoleAssignmentsAsync() {
        return getCallerRoleAssignmentsWithResponseAsync()
                .flatMap(
                        (Response<List<String>> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * List role assignments of the caller.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of Post200ApplicationJsonItemsItem.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<String> getCallerRoleAssignments() {
        return getCallerRoleAssignmentsAsync().block();
    }

    /**
     * List roles.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Synapse roles available.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SynapseRole>> getRoleDefinitionsSinglePageAsync() {
        return FluxUtil.withContext(
                        context -> service.getRoleDefinitions(this.getEndpoint(), this.getApiVersion(), context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }

    /**
     * List roles.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Synapse roles available.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SynapseRole> getRoleDefinitionsAsync() {
        return new PagedFlux<>(
                () -> getRoleDefinitionsSinglePageAsync(), nextLink -> getRoleDefinitionsNextSinglePageAsync(nextLink));
    }

    /**
     * List roles.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Synapse roles available.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SynapseRole> getRoleDefinitions() {
        return new PagedIterable<>(getRoleDefinitionsAsync());
    }

    /**
     * Get role by role Id.
     *
     * @param roleId Synapse Built-In Role Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role by role Id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SynapseRole>> getRoleDefinitionByIdWithResponseAsync(String roleId) {
        return FluxUtil.withContext(
                context -> service.getRoleDefinitionById(this.getEndpoint(), roleId, this.getApiVersion(), context));
    }

    /**
     * Get role by role Id.
     *
     * @param roleId Synapse Built-In Role Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role by role Id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SynapseRole> getRoleDefinitionByIdAsync(String roleId) {
        return getRoleDefinitionByIdWithResponseAsync(roleId)
                .flatMap(
                        (Response<SynapseRole> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Get role by role Id.
     *
     * @param roleId Synapse Built-In Role Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return role by role Id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SynapseRole getRoleDefinitionById(String roleId) {
        return getRoleDefinitionByIdAsync(roleId).block();
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Synapse roles available.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SynapseRole>> getRoleDefinitionsNextSinglePageAsync(String nextLink) {
        return FluxUtil.withContext(context -> service.getRoleDefinitionsNext(nextLink, context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }
}

// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.accesscontrol;

import com.azure.analytics.synapse.accesscontrol.implementation.AccessControlClientImpl;
import com.azure.analytics.synapse.accesscontrol.models.ErrorContractException;
import com.azure.analytics.synapse.accesscontrol.models.GetRoleAssignmentsResponse;
import com.azure.analytics.synapse.accesscontrol.models.RoleAssignmentDetails;
import com.azure.analytics.synapse.accesscontrol.models.RoleAssignmentOptions;
import com.azure.analytics.synapse.accesscontrol.models.SynapseRole;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.Response;
import java.util.List;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous AccessControlClient type. */
@ServiceClient(builder = AccessControlClientBuilder.class, isAsync = true)
public final class AccessControlAsyncClient {
    private final AccessControlClientImpl serviceClient;

    /** Initializes an instance of AccessControlClient client. */
    AccessControlAsyncClient(AccessControlClientImpl serviceClient) {
        this.serviceClient = serviceClient;
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
    public Mono<Response<RoleAssignmentDetails>> createRoleAssignmentWithResponse(
            RoleAssignmentOptions createRoleAssignmentOptions) {
        return this.serviceClient.createRoleAssignmentWithResponseAsync(createRoleAssignmentOptions);
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
    public Mono<RoleAssignmentDetails> createRoleAssignment(RoleAssignmentOptions createRoleAssignmentOptions) {
        return this.serviceClient.createRoleAssignmentAsync(createRoleAssignmentOptions);
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
    public Mono<GetRoleAssignmentsResponse> getRoleAssignmentsWithResponse(
            String roleId, String principalId, String continuationToken) {
        return this.serviceClient.getRoleAssignmentsWithResponseAsync(roleId, principalId, continuationToken);
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
    public Mono<List<RoleAssignmentDetails>> getRoleAssignments(
            String roleId, String principalId, String continuationToken) {
        return this.serviceClient.getRoleAssignmentsAsync(roleId, principalId, continuationToken);
    }

    /**
     * List role assignments.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of role assignments.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<RoleAssignmentDetails>> getRoleAssignments() {
        return this.serviceClient.getRoleAssignmentsAsync();
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
    public Mono<Response<RoleAssignmentDetails>> getRoleAssignmentByIdWithResponse(String roleAssignmentId) {
        return this.serviceClient.getRoleAssignmentByIdWithResponseAsync(roleAssignmentId);
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
    public Mono<RoleAssignmentDetails> getRoleAssignmentById(String roleAssignmentId) {
        return this.serviceClient.getRoleAssignmentByIdAsync(roleAssignmentId);
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
    public Mono<Response<Void>> deleteRoleAssignmentByIdWithResponse(String roleAssignmentId) {
        return this.serviceClient.deleteRoleAssignmentByIdWithResponseAsync(roleAssignmentId);
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
    public Mono<Void> deleteRoleAssignmentById(String roleAssignmentId) {
        return this.serviceClient.deleteRoleAssignmentByIdAsync(roleAssignmentId);
    }

    /**
     * List role assignments of the caller.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of Post200ApplicationJsonItemsItem.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<List<String>>> getCallerRoleAssignmentsWithResponse() {
        return this.serviceClient.getCallerRoleAssignmentsWithResponseAsync();
    }

    /**
     * List role assignments of the caller.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of Post200ApplicationJsonItemsItem.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<String>> getCallerRoleAssignments() {
        return this.serviceClient.getCallerRoleAssignmentsAsync();
    }

    /**
     * List roles.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Synapse roles available.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public Mono<PagedResponse<SynapseRole>> getRoleDefinitionsSinglePage() {
        return this.serviceClient.getRoleDefinitionsSinglePageAsync();
    }

    /**
     * List roles.
     *
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Synapse roles available.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SynapseRole> getRoleDefinitions() {
        return this.serviceClient.getRoleDefinitionsAsync();
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
    public Mono<Response<SynapseRole>> getRoleDefinitionByIdWithResponse(String roleId) {
        return this.serviceClient.getRoleDefinitionByIdWithResponseAsync(roleId);
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
    public Mono<SynapseRole> getRoleDefinitionById(String roleId) {
        return this.serviceClient.getRoleDefinitionByIdAsync(roleId);
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink null
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorContractException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Synapse roles available.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public Mono<PagedResponse<SynapseRole>> getRoleDefinitionsNextSinglePage(String nextLink) {
        return this.serviceClient.getRoleDefinitionsNextSinglePageAsync(nextLink);
    }
}

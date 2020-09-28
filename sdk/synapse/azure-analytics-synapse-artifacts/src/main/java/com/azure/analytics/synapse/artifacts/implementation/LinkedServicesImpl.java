// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.implementation;

import com.azure.analytics.synapse.artifacts.models.CloudErrorException;
import com.azure.analytics.synapse.artifacts.models.LinkedServiceListResponse;
import com.azure.analytics.synapse.artifacts.models.LinkedServiceResource;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in LinkedServices. */
public final class LinkedServicesImpl {
    /** The proxy service used to perform REST calls. */
    private final LinkedServicesService service;

    /** The service client containing this operation class. */
    private final ArtifactsClientImpl client;

    /**
     * Initializes an instance of LinkedServicesImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    LinkedServicesImpl(ArtifactsClientImpl client) {
        this.service =
                RestProxy.create(LinkedServicesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for ArtifactsClientLinkedServices to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "ArtifactsClientLinke")
    private interface LinkedServicesService {
        @Get("/linkedservices")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<LinkedServiceListResponse>> getLinkedServicesByWorkspace(
                @HostParam("endpoint") String endpoint, @QueryParam("api-version") String apiVersion, Context context);

        @Put("/linkedservices/{linkedServiceName}")
        @ExpectedResponses({200, 202})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<LinkedServiceResource>> createOrUpdateLinkedService(
                @HostParam("endpoint") String endpoint,
                @PathParam("linkedServiceName") String linkedServiceName,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("If-Match") String ifMatch,
                @BodyParam("application/json") LinkedServiceResource linkedService,
                Context context);

        @Get("/linkedservices/{linkedServiceName}")
        @ExpectedResponses({200, 304})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<LinkedServiceResource>> getLinkedService(
                @HostParam("endpoint") String endpoint,
                @PathParam("linkedServiceName") String linkedServiceName,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("If-None-Match") String ifNoneMatch,
                Context context);

        @Delete("/linkedservices/{linkedServiceName}")
        @ExpectedResponses({200, 202, 204})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<Void>> deleteLinkedService(
                @HostParam("endpoint") String endpoint,
                @PathParam("linkedServiceName") String linkedServiceName,
                @QueryParam("api-version") String apiVersion,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<LinkedServiceListResponse>> getLinkedServicesByWorkspaceNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink, Context context);
    }

    /**
     * Lists linked services.
     *
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<LinkedServiceResource>> getLinkedServicesByWorkspaceSinglePageAsync() {
        return FluxUtil.withContext(
                        context ->
                                service.getLinkedServicesByWorkspace(
                                        this.client.getEndpoint(), this.client.getApiVersion(), context))
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
     * Lists linked services.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<LinkedServiceResource>> getLinkedServicesByWorkspaceSinglePageAsync(Context context) {
        return service.getLinkedServicesByWorkspace(this.client.getEndpoint(), this.client.getApiVersion(), context)
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
     * Lists linked services.
     *
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<LinkedServiceResource> getLinkedServicesByWorkspaceAsync() {
        return new PagedFlux<>(
                () -> getLinkedServicesByWorkspaceSinglePageAsync(),
                nextLink -> getLinkedServicesByWorkspaceNextSinglePageAsync(nextLink));
    }

    /**
     * Lists linked services.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<LinkedServiceResource> getLinkedServicesByWorkspaceAsync(Context context) {
        return new PagedFlux<>(
                () -> getLinkedServicesByWorkspaceSinglePageAsync(context),
                nextLink -> getLinkedServicesByWorkspaceNextSinglePageAsync(nextLink, context));
    }

    /**
     * Lists linked services.
     *
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<LinkedServiceResource> getLinkedServicesByWorkspace() {
        return new PagedIterable<>(getLinkedServicesByWorkspaceAsync());
    }

    /**
     * Lists linked services.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<LinkedServiceResource> getLinkedServicesByWorkspace(Context context) {
        return new PagedIterable<>(getLinkedServicesByWorkspaceAsync(context));
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @param ifMatch ETag of the linkedService entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LinkedServiceResource>> createOrUpdateLinkedServiceWithResponseAsync(
            String linkedServiceName, LinkedServiceResource linkedService, String ifMatch) {
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateLinkedService(
                                this.client.getEndpoint(),
                                linkedServiceName,
                                this.client.getApiVersion(),
                                ifMatch,
                                linkedService,
                                context));
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @param ifMatch ETag of the linkedService entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LinkedServiceResource>> createOrUpdateLinkedServiceWithResponseAsync(
            String linkedServiceName, LinkedServiceResource linkedService, String ifMatch, Context context) {
        return service.createOrUpdateLinkedService(
                this.client.getEndpoint(),
                linkedServiceName,
                this.client.getApiVersion(),
                ifMatch,
                linkedService,
                context);
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @param ifMatch ETag of the linkedService entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LinkedServiceResource> createOrUpdateLinkedServiceAsync(
            String linkedServiceName, LinkedServiceResource linkedService, String ifMatch) {
        return createOrUpdateLinkedServiceWithResponseAsync(linkedServiceName, linkedService, ifMatch)
                .flatMap(
                        (Response<LinkedServiceResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @param ifMatch ETag of the linkedService entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LinkedServiceResource> createOrUpdateLinkedServiceAsync(
            String linkedServiceName, LinkedServiceResource linkedService, String ifMatch, Context context) {
        return createOrUpdateLinkedServiceWithResponseAsync(linkedServiceName, linkedService, ifMatch, context)
                .flatMap(
                        (Response<LinkedServiceResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LinkedServiceResource> createOrUpdateLinkedServiceAsync(
            String linkedServiceName, LinkedServiceResource linkedService) {
        final String ifMatch = null;
        return createOrUpdateLinkedServiceWithResponseAsync(linkedServiceName, linkedService, ifMatch)
                .flatMap(
                        (Response<LinkedServiceResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @param ifMatch ETag of the linkedService entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LinkedServiceResource createOrUpdateLinkedService(
            String linkedServiceName, LinkedServiceResource linkedService, String ifMatch) {
        return createOrUpdateLinkedServiceAsync(linkedServiceName, linkedService, ifMatch).block();
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LinkedServiceResource createOrUpdateLinkedService(
            String linkedServiceName, LinkedServiceResource linkedService) {
        final String ifMatch = null;
        return createOrUpdateLinkedServiceAsync(linkedServiceName, linkedService, ifMatch).block();
    }

    /**
     * Creates or updates a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param linkedService Linked service resource type.
     * @param ifMatch ETag of the linkedService entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return linked service resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LinkedServiceResource> createOrUpdateLinkedServiceWithResponse(
            String linkedServiceName, LinkedServiceResource linkedService, String ifMatch, Context context) {
        return createOrUpdateLinkedServiceWithResponseAsync(linkedServiceName, linkedService, ifMatch, context).block();
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param ifNoneMatch ETag of the linked service entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LinkedServiceResource>> getLinkedServiceWithResponseAsync(
            String linkedServiceName, String ifNoneMatch) {
        return FluxUtil.withContext(
                context ->
                        service.getLinkedService(
                                this.client.getEndpoint(),
                                linkedServiceName,
                                this.client.getApiVersion(),
                                ifNoneMatch,
                                context));
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param ifNoneMatch ETag of the linked service entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LinkedServiceResource>> getLinkedServiceWithResponseAsync(
            String linkedServiceName, String ifNoneMatch, Context context) {
        return service.getLinkedService(
                this.client.getEndpoint(), linkedServiceName, this.client.getApiVersion(), ifNoneMatch, context);
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param ifNoneMatch ETag of the linked service entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LinkedServiceResource> getLinkedServiceAsync(String linkedServiceName, String ifNoneMatch) {
        return getLinkedServiceWithResponseAsync(linkedServiceName, ifNoneMatch)
                .flatMap(
                        (Response<LinkedServiceResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param ifNoneMatch ETag of the linked service entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LinkedServiceResource> getLinkedServiceAsync(
            String linkedServiceName, String ifNoneMatch, Context context) {
        return getLinkedServiceWithResponseAsync(linkedServiceName, ifNoneMatch, context)
                .flatMap(
                        (Response<LinkedServiceResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LinkedServiceResource> getLinkedServiceAsync(String linkedServiceName) {
        final String ifNoneMatch = null;
        return getLinkedServiceWithResponseAsync(linkedServiceName, ifNoneMatch)
                .flatMap(
                        (Response<LinkedServiceResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param ifNoneMatch ETag of the linked service entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LinkedServiceResource getLinkedService(String linkedServiceName, String ifNoneMatch) {
        return getLinkedServiceAsync(linkedServiceName, ifNoneMatch).block();
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LinkedServiceResource getLinkedService(String linkedServiceName) {
        final String ifNoneMatch = null;
        return getLinkedServiceAsync(linkedServiceName, ifNoneMatch).block();
    }

    /**
     * Gets a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param ifNoneMatch ETag of the linked service entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a linked service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LinkedServiceResource> getLinkedServiceWithResponse(
            String linkedServiceName, String ifNoneMatch, Context context) {
        return getLinkedServiceWithResponseAsync(linkedServiceName, ifNoneMatch, context).block();
    }

    /**
     * Deletes a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteLinkedServiceWithResponseAsync(String linkedServiceName) {
        return FluxUtil.withContext(
                context ->
                        service.deleteLinkedService(
                                this.client.getEndpoint(), linkedServiceName, this.client.getApiVersion(), context));
    }

    /**
     * Deletes a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteLinkedServiceWithResponseAsync(String linkedServiceName, Context context) {
        return service.deleteLinkedService(
                this.client.getEndpoint(), linkedServiceName, this.client.getApiVersion(), context);
    }

    /**
     * Deletes a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteLinkedServiceAsync(String linkedServiceName) {
        return deleteLinkedServiceWithResponseAsync(linkedServiceName).flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Deletes a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteLinkedServiceAsync(String linkedServiceName, Context context) {
        return deleteLinkedServiceWithResponseAsync(linkedServiceName, context)
                .flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Deletes a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteLinkedService(String linkedServiceName) {
        deleteLinkedServiceAsync(linkedServiceName).block();
    }

    /**
     * Deletes a linked service.
     *
     * @param linkedServiceName The linked service name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteLinkedServiceWithResponse(String linkedServiceName, Context context) {
        return deleteLinkedServiceWithResponseAsync(linkedServiceName, context).block();
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<LinkedServiceResource>> getLinkedServicesByWorkspaceNextSinglePageAsync(String nextLink) {
        return FluxUtil.withContext(context -> service.getLinkedServicesByWorkspaceNext(nextLink, context))
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
     * Get the next page of items.
     *
     * @param nextLink The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of linked service resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<LinkedServiceResource>> getLinkedServicesByWorkspaceNextSinglePageAsync(
            String nextLink, Context context) {
        return service.getLinkedServicesByWorkspaceNext(nextLink, context)
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

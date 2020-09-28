// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The resource model definition for a Azure Resource Manager resource with an etag. */
@Immutable
public class AzureEntityResource extends Resource {
    /*
     * Resource Etag.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Get the etag property: Resource Etag.
     *
     * @return the etag value.
     */
    public String getEtag() {
        return this.etag;
    }
}

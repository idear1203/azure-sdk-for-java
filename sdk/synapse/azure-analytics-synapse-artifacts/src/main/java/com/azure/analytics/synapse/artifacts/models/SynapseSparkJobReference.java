// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The SynapseSparkJobReference model. */
@Fluent
public final class SynapseSparkJobReference {
    /*
     * Synapse spark job reference type.
     */
    @JsonProperty(value = "type", required = true)
    private SparkJobReferenceType type;

    /*
     * Reference spark job name.
     */
    @JsonProperty(value = "referenceName", required = true)
    private String referenceName;

    /**
     * Get the type property: Synapse spark job reference type.
     *
     * @return the type value.
     */
    public SparkJobReferenceType getType() {
        return this.type;
    }

    /**
     * Set the type property: Synapse spark job reference type.
     *
     * @param type the type value to set.
     * @return the SynapseSparkJobReference object itself.
     */
    public SynapseSparkJobReference setType(SparkJobReferenceType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the referenceName property: Reference spark job name.
     *
     * @return the referenceName value.
     */
    public String getReferenceName() {
        return this.referenceName;
    }

    /**
     * Set the referenceName property: Reference spark job name.
     *
     * @param referenceName the referenceName value to set.
     * @return the SynapseSparkJobReference object itself.
     */
    public SynapseSparkJobReference setReferenceName(String referenceName) {
        this.referenceName = referenceName;
        return this;
    }
}

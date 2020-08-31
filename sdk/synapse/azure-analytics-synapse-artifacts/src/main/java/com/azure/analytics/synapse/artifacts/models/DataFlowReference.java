// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/** The DataFlowReference model. */
@Fluent
public final class DataFlowReference {
    /*
     * Data flow reference type.
     */
    @JsonProperty(value = "type", required = true)
    private DataFlowReferenceType type;

    /*
     * Reference data flow name.
     */
    @JsonProperty(value = "referenceName", required = true)
    private String referenceName;

    /*
     * Reference data flow parameters from dataset.
     */
    @JsonProperty(value = "datasetParameters")
    private Object datasetParameters;

    /*
     * Data flow reference type.
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the type property: Data flow reference type.
     *
     * @return the type value.
     */
    public DataFlowReferenceType getType() {
        return this.type;
    }

    /**
     * Set the type property: Data flow reference type.
     *
     * @param type the type value to set.
     * @return the DataFlowReference object itself.
     */
    public DataFlowReference setType(DataFlowReferenceType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the referenceName property: Reference data flow name.
     *
     * @return the referenceName value.
     */
    public String getReferenceName() {
        return this.referenceName;
    }

    /**
     * Set the referenceName property: Reference data flow name.
     *
     * @param referenceName the referenceName value to set.
     * @return the DataFlowReference object itself.
     */
    public DataFlowReference setReferenceName(String referenceName) {
        this.referenceName = referenceName;
        return this;
    }

    /**
     * Get the datasetParameters property: Reference data flow parameters from dataset.
     *
     * @return the datasetParameters value.
     */
    public Object getDatasetParameters() {
        return this.datasetParameters;
    }

    /**
     * Set the datasetParameters property: Reference data flow parameters from dataset.
     *
     * @param datasetParameters the datasetParameters value to set.
     * @return the DataFlowReference object itself.
     */
    public DataFlowReference setDatasetParameters(Object datasetParameters) {
        this.datasetParameters = datasetParameters;
        return this;
    }

    /**
     * Get the additionalProperties property: Data flow reference type.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Data flow reference type.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the DataFlowReference object itself.
     */
    public DataFlowReference setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @JsonAnySetter
    void setAdditionalProperties(String key, Object value) {
        if (additionalProperties == null) {
            additionalProperties = new HashMap<>();
        }
        additionalProperties.put(key, value);
    }
}

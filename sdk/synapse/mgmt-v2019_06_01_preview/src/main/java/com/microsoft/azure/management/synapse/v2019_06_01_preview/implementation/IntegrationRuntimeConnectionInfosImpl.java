/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.synapse.v2019_06_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.synapse.v2019_06_01_preview.IntegrationRuntimeConnectionInfos;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.management.synapse.v2019_06_01_preview.IntegrationRuntimeConnectionInfo;

class IntegrationRuntimeConnectionInfosImpl extends WrapperImpl<IntegrationRuntimeConnectionInfosInner> implements IntegrationRuntimeConnectionInfos {
    private final SynapseManager manager;

    IntegrationRuntimeConnectionInfosImpl(SynapseManager manager) {
        super(manager.inner().integrationRuntimeConnectionInfos());
        this.manager = manager;
    }

    public SynapseManager manager() {
        return this.manager;
    }

    @Override
    public Observable<IntegrationRuntimeConnectionInfo> getAsync(String resourceGroupName, String workspaceName, String integrationRuntimeName) {
        IntegrationRuntimeConnectionInfosInner client = this.inner();
        return client.getAsync(resourceGroupName, workspaceName, integrationRuntimeName)
        .map(new Func1<IntegrationRuntimeConnectionInfoInner, IntegrationRuntimeConnectionInfo>() {
            @Override
            public IntegrationRuntimeConnectionInfo call(IntegrationRuntimeConnectionInfoInner inner) {
                return new IntegrationRuntimeConnectionInfoImpl(inner, manager());
            }
        });
    }

}
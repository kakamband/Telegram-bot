/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.jitnegii.ytspotbot.youtube.core;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class DefaultExecutorSupplier implements ExecutorSupplier {

    private static final int DEFAULT_MAX_NUM_THREADS = 2 * Runtime.getRuntime().availableProcessors() + 1;
    private final RequestExecutor requestExecutor;
    private final Executor backgroundExecutor;


    DefaultExecutorSupplier() {
        ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
        requestExecutor = new RequestExecutor(DEFAULT_MAX_NUM_THREADS, defaultThreadFactory);
        backgroundExecutor = Executors.newSingleThreadExecutor();

    }


    @Override
    public RequestExecutor forRequestTasks() {
        return requestExecutor;
    }

    @Override
    public Executor forBackgroundTasks() {
        return backgroundExecutor;
    }

}

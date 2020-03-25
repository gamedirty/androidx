/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JvmMultifileClass
@file:JvmName("RxPaging")

package androidx.paging

import io.reactivex.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.rx2.asFlowable

/**
 * Construct the primary RxJava Paging reactive stream: `Flowable<PagingData<T>>`.
 *
 * Creates a stream of [PagingData] objects, each of which represents a single generation of
 * paginated data. These objects can be transformed to alter data as it loads, and presented in a
 * `RecyclerView`.
 *
 * @see PagingDataFlow
 */
@Suppress("FunctionName", "unused")
@JvmName("flowable")
@JvmOverloads
@OptIn(ExperimentalCoroutinesApi::class)
fun <Key : Any, Value : Any> PagingDataFlowable(
    config: PagingConfig,
    initialKey: Key? = null,
    remoteMediator: RemoteMediator<Key, Value>? = null,
    pagingSourceFactory: () -> PagingSource<Key, Value>
): Flowable<PagingData<Value>> =
    PagingDataFlow(config, initialKey, remoteMediator, pagingSourceFactory)
        .conflate()
        .asFlowable()

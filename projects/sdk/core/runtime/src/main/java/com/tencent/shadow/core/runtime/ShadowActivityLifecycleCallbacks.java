/*
 * Tencent is pleased to support the open source community by making Tencent Shadow available.
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.tencent.shadow.core.runtime.container.PluginContainerActivity;

public interface ShadowActivityLifecycleCallbacks {

    void onActivityCreated(ShadowActivity activity, Bundle savedInstanceState);

    void onActivityStarted(ShadowActivity activity);

    void onActivityResumed(ShadowActivity activity);

    void onActivityPaused(ShadowActivity activity);

    void onActivityStopped(ShadowActivity activity);

    void onActivitySaveInstanceState(ShadowActivity activity, Bundle outState);

    void onActivityDestroyed(ShadowActivity activity);

    void onActivityPreCreated(ShadowActivity activity, Bundle savedInstanceState);

    void onActivityPostStarted(ShadowActivity activity);

    void onActivityPostResume(ShadowActivity activity);

    void onActivityPostCreated(ShadowActivity activity, Bundle savedInstanceState);

    void onActivityPreStarted(ShadowActivity activity);

    void onActivityPreResumed(ShadowActivity activity);

    void onActivityPrePaused(ShadowActivity activity);

    void onActivityPostPaused(ShadowActivity activity);

    void onActivityPreStopped(ShadowActivity activity);

    void onActivityPostStopped(ShadowActivity activity);

    void onActivityPreSaveInstanceState(ShadowActivity activity, Bundle outState);

    void onActivityPostSaveInstanceState(ShadowActivity activity, Bundle outState);

    void onActivityPreDestroyed(ShadowActivity activity);

    void onActivityPostDestroyed(ShadowActivity activity);

    @SuppressWarnings("NullableProblems")
    class Wrapper implements Application.ActivityLifecycleCallbacks {

        final ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks;
        final ShadowApplication shadowApplication;

        public Wrapper(ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks, ShadowApplication shadowApplication) {
            this.shadowActivityLifecycleCallbacks = shadowActivityLifecycleCallbacks;
            this.shadowApplication = shadowApplication;
        }

        private ShadowActivity getPluginActivity(Activity activity) {
            if (activity instanceof PluginContainerActivity) {
                return (ShadowActivity) PluginActivity.get((PluginContainerActivity) activity);
            } else {
                return null;
            }
        }

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity) ) {
                shadowActivityLifecycleCallbacks.onActivityCreated(pluginActivity, savedInstanceState);
            }
        }

        @Override
        public void onActivityStarted(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity) ) {
                shadowActivityLifecycleCallbacks.onActivityStarted(pluginActivity);
            }
        }

        @Override
        public void onActivityResumed(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity) ) {
                shadowActivityLifecycleCallbacks.onActivityResumed(pluginActivity);
            }
        }

        @Override
        public void onActivityPaused(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity) ) {
                shadowActivityLifecycleCallbacks.onActivityPaused(pluginActivity);
            }
        }

        @Override
        public void onActivityStopped(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity) ) {
                shadowActivityLifecycleCallbacks.onActivityStopped(pluginActivity);
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity) ) {
                shadowActivityLifecycleCallbacks.onActivitySaveInstanceState(pluginActivity, outState);
            }
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity) ) {
                shadowActivityLifecycleCallbacks.onActivityDestroyed(pluginActivity);
            }
        }

        @Override
        public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPreCreated(pluginActivity, savedInstanceState);
            }
        }

        @Override
        public void onActivityPostStarted(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPostStarted(pluginActivity);
            }
        }

        @Override
        public void onActivityPostResumed(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPostResume(pluginActivity);
            }
        }

        @Override
        public void onActivityPostCreated(Activity activity, Bundle savedInstanceState) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPostCreated(pluginActivity, savedInstanceState);
            }
        }

        @Override
        public void onActivityPreStarted(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPreStarted(pluginActivity);
            }
        }

        @Override
        public void onActivityPreResumed(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPreResumed(pluginActivity);
            }
        }

        @Override
        public void onActivityPrePaused(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPrePaused(pluginActivity);
            }
        }

        @Override
        public void onActivityPostPaused(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPostPaused(pluginActivity);
            }
        }

        @Override
        public void onActivityPreStopped(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPreStopped(pluginActivity);
            }
        }

        @Override
        public void onActivityPostStopped(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPostStopped(pluginActivity);
            }
        }

        @Override
        public void onActivityPreSaveInstanceState(Activity activity, Bundle outState) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPreSaveInstanceState(pluginActivity, outState);
            }
        }

        @Override
        public void onActivityPostSaveInstanceState(Activity activity, Bundle outState) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPostSaveInstanceState(pluginActivity, outState);
            }
        }

        @Override
        public void onActivityPreDestroyed(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPreDestroyed(pluginActivity);
            }
        }

        @Override
        public void onActivityPostDestroyed(Activity activity) {
            final ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                shadowActivityLifecycleCallbacks.onActivityPostDestroyed(pluginActivity);
            }
        }

        /**
         * 检测Activity是否属于当前Application所在的插件
         *
         * @param activity 插件Activity
         * @return 是否属于当前Application所在的插件 true属于
         */
        private boolean checkOwnerActivity(PluginActivity activity) {
            return activity != null && activity.mPluginApplication == shadowApplication;
        }
    }
}

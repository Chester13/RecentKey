LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)


LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, src)

#LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res

LOCAL_PACKAGE_NAME := RecentKey
#LOCAL_CERTIFICATE := platform
#LOCAL_PRIVILEGED_MODULE := true
LOCAL_DEX_PREOPT := false

#LOCAL_PROGUARD_FLAG_FILES := proguard.flags

#ifneq ($(INCREMENTAL_BUILDS),)
#    LOCAL_PROGUARD_ENABLED := disabled
#    LOCAL_JACK_ENABLED := incremental
#endif


include $(BUILD_PACKAGE)

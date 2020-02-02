package vit.khundenko.android.startfinishactivity.demo

import android.content.Intent
import android.os.Build

object IntentFlagUtils {

    private val POSSIBLE_FLAGS = getPossibleFlags()

    fun getFlagNames(intent: Intent): List<String> {
        return POSSIBLE_FLAGS.filter { flag ->
            intent.flags.and(flag.value) == flag.value
        }.map { flag ->
            flag.name
        }
    }

    private fun getPossibleFlags(): List<Flag> {
        val flags = mutableListOf(
            Flag(Intent.FLAG_GRANT_READ_URI_PERMISSION, "FLAG_GRANT_READ_URI_PERMISSION"),
            Flag(Intent.FLAG_GRANT_WRITE_URI_PERMISSION, "FLAG_GRANT_WRITE_URI_PERMISSION"),
            Flag(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION, "FLAG_GRANT_PERSISTABLE_URI_PERMISSION"),
            Flag(Intent.FLAG_GRANT_PREFIX_URI_PERMISSION, "FLAG_GRANT_PREFIX_URI_PERMISSION"),
            Flag(Intent.FLAG_FROM_BACKGROUND, "FLAG_FROM_BACKGROUND"),
            Flag(Intent.FLAG_DEBUG_LOG_RESOLUTION, "FLAG_DEBUG_LOG_RESOLUTION"),
            Flag(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES, "FLAG_EXCLUDE_STOPPED_PACKAGES"),
            Flag(Intent.FLAG_INCLUDE_STOPPED_PACKAGES, "FLAG_INCLUDE_STOPPED_PACKAGES"),
            Flag(Intent.FLAG_ACTIVITY_NO_HISTORY, "FLAG_ACTIVITY_NO_HISTORY"),
            Flag(Intent.FLAG_ACTIVITY_SINGLE_TOP, "FLAG_ACTIVITY_SINGLE_TOP"),
            Flag(Intent.FLAG_ACTIVITY_NEW_TASK, "FLAG_ACTIVITY_NEW_TASK"),
            Flag(Intent.FLAG_ACTIVITY_MULTIPLE_TASK, "FLAG_ACTIVITY_MULTIPLE_TASK"),
            Flag(Intent.FLAG_ACTIVITY_CLEAR_TOP, "FLAG_ACTIVITY_CLEAR_TOP"),
            Flag(Intent.FLAG_ACTIVITY_FORWARD_RESULT, "FLAG_ACTIVITY_FORWARD_RESULT"),
            Flag(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP, "FLAG_ACTIVITY_PREVIOUS_IS_TOP"),
            Flag(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS, "FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS"),
            Flag(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT, "FLAG_ACTIVITY_BROUGHT_TO_FRONT"),
            Flag(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED, "FLAG_ACTIVITY_RESET_TASK_IF_NEEDED"),
            Flag(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY, "FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY"),
            Flag(Intent.FLAG_ACTIVITY_NEW_DOCUMENT, "FLAG_ACTIVITY_NEW_DOCUMENT"),
            Flag(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET, "FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET"),
            Flag(Intent.FLAG_ACTIVITY_NO_USER_ACTION, "FLAG_ACTIVITY_NO_USER_ACTION"),
            Flag(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT, "FLAG_ACTIVITY_REORDER_TO_FRONT"),
            Flag(Intent.FLAG_ACTIVITY_NO_ANIMATION, "FLAG_ACTIVITY_NO_ANIMATION"),
            Flag(Intent.FLAG_ACTIVITY_CLEAR_TASK, "FLAG_ACTIVITY_CLEAR_TASK"),
            Flag(Intent.FLAG_ACTIVITY_TASK_ON_HOME, "FLAG_ACTIVITY_TASK_ON_HOME"),
            Flag(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS, "FLAG_ACTIVITY_RETAIN_IN_RECENTS"),
            Flag(Intent.FLAG_RECEIVER_REGISTERED_ONLY, "FLAG_RECEIVER_REGISTERED_ONLY"),
            Flag(Intent.FLAG_RECEIVER_REPLACE_PENDING, "FLAG_RECEIVER_REPLACE_PENDING"),
            Flag(Intent.FLAG_RECEIVER_FOREGROUND, "FLAG_RECEIVER_FOREGROUND"),
            Flag(Intent.FLAG_RECEIVER_NO_ABORT, "FLAG_RECEIVER_NO_ABORT")
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            flags.add(Flag(Intent.FLAG_ACTIVITY_MATCH_EXTERNAL, "FLAG_ACTIVITY_MATCH_EXTERNAL"))
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            flags.add(Flag(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT, "FLAG_ACTIVITY_LAUNCH_ADJACENT"))
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            flags.add(Flag(Intent.FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS, "FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS"))
        }

        return flags
    }

    private class Flag(val value: Int, val name: String)
}
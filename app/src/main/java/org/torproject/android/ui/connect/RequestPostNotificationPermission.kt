package org.torproject.android.ui.connect

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import org.torproject.android.R

class RequestPostNotificationPermission : DialogFragment() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireActivity())
            .setTitle(R.string.request_notification_permission)
            .setMessage(R.string.request_notification_permission_msg)
            .setCancelable(false)
            .setPositiveButton(
                R.string.open_settings
            ) { dialog: DialogInterface?, which: Int ->
                val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .putExtra(Settings.EXTRA_APP_PACKAGE, requireActivity().packageName)

                startActivity(intent)
                dismiss()
            }
            .create()
}
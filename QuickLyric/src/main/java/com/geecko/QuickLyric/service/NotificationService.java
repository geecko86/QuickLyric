/*
 * *
 *  * This file is part of QuickLyric
 *  * Created by geecko
 *  *
 *  * QuickLyric is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * QuickLyric is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  * You should have received a copy of the GNU General Public License
 *  * along with QuickLyric.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.geecko.QuickLyric.service;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

import com.geecko.QuickLyric.R;

public class NotificationService extends IntentService {

    /**
     * A constructor is required, and must call the super IntentService(String)
     * constructor with a name for the worker thread.
     */
    public NotificationService() {
        super("NotificationService");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onHandleIntent(Intent intent) {
        // Load preferences
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences current = getSharedPreferences("current_music", Context.MODE_PRIVATE);
        int notificationPref = Integer.valueOf(sharedPref.getString("pref_notifications", "0"));
        String artist = current.getString("artist", "Michael Jackson");
        String track = current.getString("track", "Bad");

        Intent activityIntent = new Intent("com.geecko.QuickLyric.getLyrics")
                .putExtra("TAGS", new String[]{artist, track});
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, activityIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this);

        if (sharedPref.getString("pref_theme", "0").equals("0"))
            notifBuilder.setColor(getResources().getColor(R.color.primary));
        notifBuilder.setSmallIcon(R.drawable.ic_notif);
        notifBuilder.setContentTitle(getString(R.string.app_name));
        notifBuilder.setContentText(String.format("%s - %s", artist, track));
        notifBuilder.setContentIntent(pendingIntent);
        if (sharedPref.getBoolean("pref_hide_notification", false) && (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN))
            notifBuilder.setPriority(Notification.PRIORITY_MIN);
        else
            notifBuilder.setPriority(-1);
        Notification notif = notifBuilder.build();
        if (notificationPref == 2)
            notif.flags |= Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT;
        else
            notif.flags |= Notification.FLAG_AUTO_CANCEL;

        if (intent.getBooleanExtra("show_notification", true))
            ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE))
                    .notify(0, notif);
        else
            ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE))
                    .cancel(0);


	}
}

# QuickLyric


![alt text](https://raw.githubusercontent.com/geecko86/QuickLyric/master/banner.png "Banner Logo")

QuickLyric is an android app that instantly fetches your lyrics for you. Its main perks is that it's very fast, features Material Design as well as a search engine, a Karaoke mode, the downloading of all your lyrics on your device & some handy settings. While most lyrics app require you to type the name of the song you're searching for or annoy you with tedious notifications every time the song has changed, QuickLyric automatically detects what song is playing on your device and instantly delivers the lyrics to you.

QuickLyric is written in Java and runs on phones and tablets equipped with Android 4.0 or higher.
The build system relies on Gradle and Android Studio is therefore recommended.

## Download (free, no ads)

[![Download from F-Droid](https://camo.githubusercontent.com/7df0eafa4433fa4919a56f87c3d99cf81b68d01c/68747470733a2f2f662d64726f69642e6f72672f77696b692f696d616765732f632f63342f462d44726f69642d627574746f6e5f617661696c61626c652d6f6e2e706e67 "Download from F-Droid")](https://fossdroid.com/a/quicklyric-2.html) 

or on [the original F-Droid page](https://f-droid.org/repository/browse/?fdid=com.geecko.QuickLyric).

*Note: This is the old 1.8 release of QuickLyric. A beta for QuickLyric 2.0 is available on [the Google+ page](plus.google.com/communities/115504114424315189412).*

## Donate

If you want to support my work as a developer (not for this app specifically), you may make a donation [here](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=RSJZUSUHBBKTJ&lc=US&item_name=geecko&item_number=00&currency_code=EUR&bn=PP%2dDonationsBF%3abtn_donate_LG%2egif%3aNonHosted).

## Features

* **Lyrics** - Shows the lyrics of the song you are listening to at the moment. The Refresh button allows your to update the lyrics when the next song has started playing. In the action bar, you can to download the lyrics on your device (for offline usage), search and share the URL with a friend. If you're lucky, the Karaoke mode might be available for that song.
* **Saved Lyrics** - Each lyrics can be stored on your device.
* **Search** - Search for Lyrics on Genius.
* **Batch Download** - Download the lyrics for all your music in a few minutes.
* **Material Design**
* **System Integration** - Access the lyrics you want after you've identified a song with Shazam or Soundhound via the share button. Open URLs from Genius.com and LyricWikia directly with the app.
* **NFC** - Share lyrics with your friends via Android Beam.
* **More than 15 languages supported** - Including German, Greek, Spanish, French, Italian, Japanese, Dutch, Polish, Russian, Turkish and English.

## Build
* Make sure you have the **latest** version of Gradle installed. You should have at least the version that is used in Quicklyric/build.gradle.
* Download the sources
* **Edit the different API keys in the com.geecko.QuickLyric.Keys file.**
* Input your signature keystore, login and passwords into the QuickLyric/build.gradle file
* cd to the root of the project and execute "$ gradle build"

## Translations

What QuickLyric needs most right now is translations!
If you're bilingual you can submit translations over at [Crowdin](https://crowdin.com/project/quicklyric/invite/public?show_welcome&d=f326bebae52bede2605396991089b9bf380270) (no need to register, just use your GitHub/Google/Facebook/Twitter account). 

**Every translator may request 1 free beer if they live in Brussels.** ;)

## Open Source Contributors

If you want to expand the lyrics catalog, check out the [wiki](https://github.com/geecko86/QuickLyric/wiki/Expanding-the-catalog).

Don't be afraid to contribute! I welcome all forks & pull requests but *please*, if you want to fork QL, immediately update com.geecko.quicklyric.Keys with your own LastFM key.

## Credits

Credits are due to : Last.FM, Roman Nurik for his scroll tricks, Ficus Kirkpatrick for Volley, Jake Wharton for his ViewPagerIndicator and makovkastar for the FloatingActionButton library.

## Screenshots
![Imgur](https://i.imgur.com/IPy7VBv.png)
![Imgur](https://i.imgur.com/6iyLW0m.png)
![Imgur](https://i.imgur.com/ITCmin4.png)
![Imgur](https://i.imgur.com/QkUIvEw.png)
![Imgur](https://i.imgur.com/P1ezQjY.png)

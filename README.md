# SignalView for android

![Screenshot](screenshot.png)

This is a custom view use to display signal strength. You can change some of the properties of SignalView

    1. Line Count
    2. Primary Color
    3. Progress Color
    4. Progress
    5. Spacing between two towers

 You can add gradle dependencies to use this view 
    
    compile 'com.praween.signalview:signalview:1.0'

 Here is the code snippet which you need to use in your layout xml file in which you want to display signals tower.
 These all attributes can be changed via XML as well as programmatically.

      <com.example.praween.signalviewsample.SignalView
              android:id="@+id/sv_signal"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              app:progress="6"
              app:line_count="10"
              app:progress_color="@color/colorAccent"
              app:primary_color="@color/colorBlack"
              app:corner_radius="20"
              app:signal_spacing="10"
              android:layout_margin="10dp"/>


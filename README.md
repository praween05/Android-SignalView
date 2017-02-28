# SignalView for android

Use to display signal strength. You can changesome of the properties of SignalView

    1. Line Count
    2. Primary Color
    3. Progress Color
    4. Progress
    5. Spacing between two towers

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

 This is the code snippet by which You can use it in your project.

Audiokode
======

Allows to play sounds and musics with OpenAL, with an API similar to Paulscode's 3DSoundSystem.
Written in Kotlin (meaning it's also compatible with Java)

Example usage:
(kotlin)
```kotlin
        // Initialisation
        val engine = SoundEngine()
        engine.initWithDefaultOpenAL()
        
        // ...
        
        // Playing a background music
        val source = engine.backgroundMusic("TestWav", looping = false)
        source.play()
        source.gain = 0.15f // control the gain
        
        // ...
        // in your update/tick/pollEvents application loop:
        engine.update() // this allows the engine to move the listener, update streaming sources etc.
```

Example usage:
(java)
```java
        // Initialisation
        SoundEngine engine = new SoundEngine();
        engine.initWithDefaultOpenAL();
        
        // ...
        
        // Playing a background music
        Source source = engine.backgroundMusic("TestWav", false);
        source.play();
        source.setGain(0.15f); // control the gain
        
        // ...
        // in your update/tick/pollEvents application loop:
        engine.update(); // this allows the engine to move the listener, update streaming sources etc.
```


The library also allows for quickplaying musics and sounds, ie. playing a non-looping audio stream/file immediately and disposing its resources when it finishes:
```java
        engine.quickplayBackgroundMusic("TestWav");
        // ...
        // in your update/tick/pollEvents application loop:
        engine.update(); 
        // this allows the engine to dispose the resources at the end of playing
```

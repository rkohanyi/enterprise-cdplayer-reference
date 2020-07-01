# About

1. Build the project with `mvn package`
1. Open a console and run `rmiregistry` at `target/classes` or use `rmiregistry.exe -J-cp -Jtarget/classes`

**Important**: restart `rmiregistry` after you restart `SpotifyServer`.

## Running from an IDE
1. Run `PlayerClient` from your IDE
1. Run `SpotifyServer` from your IDE, make sure the working directory is set to the project's root directory)

## Running from the console
1. Run `PlayerClient` like `java -cp target/classes hu.codecool.player.PlayerClient`
1. It's complicated to run `SpotifyServer` from the command-line since it needs JAXB as its dependency, don't bother...


# FiveM Player List For Java!
Parses the players.json from FiveM.

# Methods
```Java	
	public String returnNameAndId(int listNumber) {
		return (players[listNumber] + " " + playerId[listNumber]);
	}
	
	public String returnName(int listNumber) {
		return players[listNumber];
	}
	
	public String returnId(int listNumber) {
		return playerId[listNumber];
	}
	
	public int playerCount() {
		return PlayerCount;
	}
	
	public String getSteamIdentifier(int listNumber) {
		return identifier[listNumber][0];
	}
	
	public String getLicenseKey(int listNumber) {
		return identifier[listNumber][1];
	}
```

# Librarys Needed
## OKHTTP3 (3.11.0) - Grabbing JSON
http://square.github.io/okhttp/
## Argo 5.4 - Parsing JSON
https://http://argo.sourceforge.net
## Okio 1.13.0 - Needed for OKHTTP3
https://mvnrepository.com/artifact/com.squareup.okio/okio/1.13.0

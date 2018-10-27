import java.io.IOException;
import org.json.simple.parser.ParseException;
import argo.jdom.JdomParser;
import argo.saj.InvalidSyntaxException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class getPlayers
{
	public final int SLOTS = 32;
	private String[] players = new String[SLOTS];
	private String[] playerId = new String[SLOTS];
	private String[][] identifier = new String[SLOTS][2];
	private String[] playerPing = new String[SLOTS];
    private boolean[] getCount = new boolean[SLOTS];
	public int PlayerCount = 0;
	
	
	private config cfg = new config();
	
	private final String linkRef = "http://" + cfg.SERVER_IP + "/players.json";
	
	private OkHttpClient client = new OkHttpClient();
	
	
	
	public getPlayers() throws IOException, ParseException, InvalidSyntaxException {
		initPlayers();
	}
	
	private String loadJSON() throws IOException
	{
		Request rq = new Request.Builder()
				.url(linkRef)
				.build();
		Response response = client.newCall(rq).execute();
		return response.body().string();
	}
	
	private void initPlayers() throws InvalidSyntaxException, IOException {
		String jsonString = loadJSON();
		
		for (int x = 0; x < SLOTS; x++) {
			getCount[x] = new JdomParser().parse(jsonString).isNode(x + 1);
			if (getCount[x]) {
				PlayerCount++;
				String getName = new JdomParser().parse(jsonString)
						.getNullableStringValue(x, "name");
				String getId = new JdomParser().parse(jsonString)
						.getNullableNumberValue(x, "id");
				String getSteamId = new JdomParser().parse(jsonString)
						.getNullableStringValue(x, "identifiers", 0);
				String getLicense = new JdomParser().parse(jsonString)
						.getNullableStringValue(x, "identifiers", 1);
				String getPing = new JdomParser().parse(jsonString)
						.getNumberValue(x, "ping");
				players[x] = getName;
				playerId[x] = getId;
				identifier[x][0] = getSteamId;
				identifier[x][1] = getLicense;
				playerPing[x] = getPing;
			}
		}
	}
	
	
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
	
}

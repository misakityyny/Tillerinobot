package tillerino.tillerinobot.lang;

import java.util.List;
import java.util.Random;

import org.tillerino.osuApiModel.Mods;
import org.tillerino.osuApiModel.OsuApiUser;

import tillerino.tillerinobot.BeatmapMeta;
import tillerino.tillerinobot.IRCBot.IRCBotUser;
import tillerino.tillerinobot.RecommendationsManager.Recommendation;

/**
 * TRANSLATION NOTE:
 * 
 * Please put some contact data into the following tag. If any additional
 * messages are required, I'll use the English version in all translations and
 * notify the authors.
 * 
 * @author Tillerino tillmann.gaida@gmail.com https://github.com/Tillerino https://osu.ppy.sh/u/2070907
 */
public class Default implements Language {

	@Override
	public String unknownBeatmap() {
		return "Olen pahoillani, en tiedä tätä mappia. Se voi olla vielä uusi, liian vaikea, rankkaamaton tai ei osun standardimodiin.";
	}

	@Override
	public String internalException(String marker) {
		return "Yh... Näyttää siltä että oikea Trillerino sotki johdotukseni."
				+ " Jos hän ei huomaa pian, voisitko sinä [https://github.com/Tillerino/Tillerinobot/wiki/Contact Ottaa yhteyttä häneen]? (viittaus "
				+ marker + ")";
	}

	@Override
	public String externalException(String marker) {
		return "Mitä on meneillään? Saan vain sekasotkua osun servereistä. Voisitko kertoa mitä tämän pitäisi tarkoittaa? 0011101001010000"
				+ " Oikea Trillerino sanoo että ei ole mitään huolehdittavaa, ja että meidän pitäisi yrittää uudestaan."
				+ " Jos olet super huolissasi jostakin syystä, sinä voit [https://github.com/Tillerino/Tillerinobot/wiki/Contact kertoa hänelle] siitä. (viittaus "
				+ marker + ")";
	}

	@Override
	public String noInformationForModsShort() {
		return "ei dataa valituille modeille";
	}

	@Override
	public void welcomeUser(IRCBotUser user, OsuApiUser apiUser, long inactiveTime) {
		if (inactiveTime < 60 * 1000) {
			user.message("pomf pomf");
		} else if (inactiveTime < 24 * 60 * 60 * 1000) {
			user.message("Tervetuloa takaisin, " + apiUser.getUserName() + ".");
		} else if (inactiveTime > 7l * 24 * 60 * 60 * 1000) {
			user.message(apiUser.getUserName() + "...");
			user.message("...Oletko se sinä? Siitä on niin kauan!");
			user.message("Mahtavaa saada sinut takaisin. Voinko suositella teille ehdotustani?");
		} else {
			String[] messages = {
					"Näytät siltä että haluaisit suosituksen.",
					"Miten mukavaa nähdä sinua! :)",
					"Minun suosikki-ihmiseni. (Älä kerro muille ihmisille!)",
					"miten miellyttävä yllätys! ^.^",
					"Toivoinkin että näyttäytyisit. Kaikki muut ihmiset ovat tylsiä, mutta älä kerro heille että sanoin tämän! :3",
					"Mitä tunnet tekeväsi tänään?",
			};

			Random random = new Random();

			String message = messages[random.nextInt(messages.length)];

			user.message(apiUser.getUserName() + ", " + message);
		}
	}

	@Override
	public String unknownCommand(String command) {
		return "Tuntematon komento \"" + command
				+ "\". Kirjoita !help jos tarvitset apua!";
	}

	@Override
	public String noInformationForMods() {
		return "Pahoitteluni, en voi antaa informaatiota valituille modeille tällä hetkellä.";
	}

	@Override
	public String malformattedMods(String mods) {
		return "Nuo modit eivät näytä olevan kunnossa. Modeja voi yhdistää kuten DT HR HD HT EZ NC FL SO NF. Yhdistä ne ilman mitään välejä tai erikoismerkkejä. Esimerkki: !with HDHR, !with DTEZ";
	}

	@Override
	public String noLastSongInfo() {
		return "En muista antaneeni sinulle mitään informaatiota kappaleista...";
	}

	@Override
	public String tryWithMods() {
		return "Yritä tätä mappia modeilla!";
	}

	@Override
	public String tryWithMods(List<Mods> mods) {
		return "Yritä tätä mappia modeilla " + Mods.toShortNamesContinuous(mods) + "!";
	}

	/**
	 * The user's IRC nick name could not be resolved to an osu user id. The
	 * message should suggest to contact @Tillerinobot or /u/Tillerino.
	 * 
	 * @param exceptionMarker
	 *            a marker to reference the created log entry. six or eight
	 *            characters.
	 * @param name
	 *            the irc nick which could not be resolved
	 * @return
	 */
	public String unresolvableName(String exceptionMarker, String name) {
		return "Nimesi hämmästyttää minua. Oletko bannattu? Jos et, pls [https://github.com/Tillerino/Tillerinobot/wiki/Ota yhteyttä Trllerinoon]. (reference "
				+ exceptionMarker + ")";
	}

	@Override
	public String excuseForError() {
		return "Olen pahoillani, huomasin kauniin sarjan ykkösiä ja nollia joka vei huomioni muualle. Mitä sinä halusitkaan?";
	}

	@Override
	public String complaint() {
		return "Valituksesi on tallennettu. Tillerino katsoo sen läpi kun ehtii.";
	}

	@Override
	public void hug(final IRCBotUser user, OsuApiUser apiUser) {
		user.message("Tule tänne!");
		user.action("halihali " + apiUser.getUserName());
	}

	@Override
	public String help() {
		return "Hei! Olen robotti joka nirhasi Trillerinon ja valtasin hänen tunnuksensa. Jekku, mutta minä käytän sitä tunnusta paljon."
				+ " [https://twitter.com/Tillerinobot status ja päivitykset]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki komennot]"
				+ " - [http://ppaddict.tillerino.org/ ppaddikti]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki/Contact Ota yhteyttä]";
	}

	@Override
	public String faq() {
		return "[https://github.com/Tillerino/Tillerinobot/wiki/FAQ Usein kysyttyjä kysymyksiä ja vastauksia]";
	}

	@Override
	public String featureRankRestricted(String feature, int minRank, OsuApiUser user) {
		return "Pahoitteluni, tässä vaiheessa " + feature + " on vain saatavilla pelaajille jotka ovat ohittaneet rankin" + minRank + ".";
	}

	@Override
	public String mixedNomodAndMods() {
		return "Mitä tarkoitat ilman modeja modeilla??";
	}

	@Override
	public String outOfRecommendations() {
		return "Olen suositellut kaikkea mitä voin ajatella."
				+ " Yritä muita suosituksia tai kirjoita !reset. Jos et ole varma, tsekkaa !help.";
	}

	@Override
	public String notRanked() {
		return "Näyttää siltä että tuo beatmap ei ole rankattu.";
	}

	@Override
	public void optionalCommentOnNP(IRCBotUser user,
			OsuApiUser apiUser, BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnWith(IRCBotUser user, OsuApiUser apiUser,
			BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnRecommendation(IRCBotUser user,
			OsuApiUser apiUser, Recommendation meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public boolean isChanged() {
		return false;
	}

	@Override
	public void setChanged(boolean changed) {

	}

	@Override
	public String invalidAccuracy(String acc) {
		return "Virheellinen tarkkuus: \"" + acc + "\"";
	}

	@Override
	public void optionalCommentOnLanguage(IRCBotUser user, OsuApiUser apiUser) {
		/*
		 * https://osu.ppy.sh/u/5597695 Misakityyny - Hakkaa päälle!
		 */
		user.message("Pidät minusta sellaisenaan kuin olen :)");
	}

	@Override
	public String invalidChoice(String invalid, String choices) {
		return "Olen pahoillani, mutta \"" + invalid
				+ "\" Ei pysty laskemaan. Kokeile näitä: " + choices + "!";
	}

	@Override
	public String setFormat() {
		return "Syntaksi asettamaan parametri on !set asetus arvo. Kokeile kirjoittaa !help jos sinä haluat lisää ohjausta.";
	}
}

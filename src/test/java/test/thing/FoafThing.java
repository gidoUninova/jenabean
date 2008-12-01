package test.thing;

import java.net.URI;
import java.util.Collection;

import thewebsemantic.As;
import thewebsemantic.Functional;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://xmlns.com/foaf/0.1/")
public interface FoafThing extends As {
	interface Person extends FoafThing {
	}

	FoafThing jabberID(String s);

	Collection<String> jabberID();

	FoafThing nick(Object string);

	Collection<Thing> nick();

	FoafThing dnaChecksum(String s);

	Collection<String> dnaChecksum();

	FoafThing topic(Thing t);

	Collection<Thing> topic();

	FoafThing theme(Thing t);

	Collection<Thing> theme();

	FoafThing msnChatID(String s);

	Collection<String> msnChatID();

	FoafThing family_name(String s);

	Collection<String> family_name();

	FoafThing openid(Thing t);

	Collection<Thing> openid();

	FoafThing schoolHomepage(Object uri);

	Collection<Thing> schoolHomepage();

	FoafThing pastProject(Thing t);

	Collection<Thing> pastProject();

	FoafThing plan(String s);

	Collection<String> plan();

	FoafThing myersBriggs(String s);

	Collection<String> myersBriggs();

	FoafThing mbox(Thing t);

	Collection<Thing> mbox();

	@Functional
	FoafThing gender(String s);

	String gender();

	FoafThing sha1(Thing t);

	Collection<Thing> sha1();

	FoafThing publications(Thing t);

	Collection<Thing> publications();

	FoafThing holdsAccount(Thing t);

	Collection<Thing> holdsAccount();

	FoafThing currentProject(Thing t);

	Collection<Thing> currentProject();

	FoafThing workInfoHomepage(Object t);

	Collection<Thing> workInfoHomepage();

	FoafThing made(Thing t);

	Collection<Thing> made();

	FoafThing aimChatID(String s);

	Collection<String> aimChatID();

	@Functional
	FoafThing primaryTopic(Thing t);

	Thing primaryTopic();

	FoafThing thumbnail(Thing t);

	Collection<Thing> thumbnail();

	FoafThing based_near(Thing t);

	Collection<Thing> based_near();

	FoafThing workplaceHomepage(Object t);

	Collection<Thing> workplaceHomepage();

	FoafThing logo(Thing t);

	Collection<Thing> logo();

	FoafThing weblog(Object t);

	Collection<Thing> weblog();

	FoafThing title(Object t);

	Collection<Thing> title();

	FoafThing fundedBy(Thing t);

	Collection<Thing> fundedBy();

	FoafThing depiction(Thing t);

	Collection<Thing> depiction();

	FoafThing accountServiceHomepage(Thing t);

	Collection<Thing> accountServiceHomepage();

	FoafThing page(Thing t);

	Collection<Thing> page();

	FoafThing isPrimaryTopicOf(Thing t);

	Collection<Thing> isPrimaryTopicOf();

	FoafThing surname(String s);

	Collection<String> surname();

	FoafThing firstName(String s);

	Collection<String> firstName();

	FoafThing homepage(Object uri);

	Collection<Thing> homepage();

	FoafThing knows(Thing t);

	Collection<Thing> knows();

	FoafThing depicts(Thing t);

	Collection<Thing> depicts();

	FoafThing interest(Thing t);

	Collection<Thing> interest();

	FoafThing geekcode(String s);

	Collection<String> geekcode();

	FoafThing mbox_sha1sum(String s);

	Collection<String> mbox_sha1sum();

	FoafThing accountName(String s);

	Collection<String> accountName();

	FoafThing membershipClass(Thing t);

	Collection<Thing> membershipClass();

	FoafThing tipjar(Thing t);

	Collection<Thing> tipjar();

	FoafThing maker(Thing t);

	Collection<Thing> maker();

	FoafThing name(String s);

	Collection<String> name();

	FoafThing img(Thing t);

	Collection<Thing> img();

	@Functional
	FoafThing birthday(String s);

	String birthday();

	FoafThing givenname(Thing t);

	Collection<Thing> givenname();

	FoafThing member(Thing t);

	Collection<Thing> member();

	FoafThing yahooChatID(String s);

	Collection<String> yahooChatID();

	FoafThing icqChatID(String s);

	Collection<String> icqChatID();

	FoafThing phone(Thing t);

	Collection<Thing> phone();

	FoafThing topic_interest(Thing t);

	Collection<Thing> topic_interest();
}

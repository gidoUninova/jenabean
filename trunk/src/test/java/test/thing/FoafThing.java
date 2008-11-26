package test.thing;

import java.util.Collection;

import thewebsemantic.As;
import thewebsemantic.Functional;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://xmlns.com/foaf/0.1/")
public interface FoafThing extends As {
	
	   public FoafThing jabberID(String s);
	   public Collection<String> jabberID();
	   public FoafThing nick(Thing t);
	   public Collection<Thing> nick();
	   public FoafThing dnaChecksum(String s);
	   public Collection<String> dnaChecksum();
	   public FoafThing topic(Thing t);
	   public Collection<Thing> topic();
	   public FoafThing theme(Thing t);
	   public Collection<Thing> theme();
	   public FoafThing msnChatID(String s);
	   public Collection<String> msnChatID();
	   public FoafThing family_name(String s);
	   public Collection<String> family_name();
	   public FoafThing openid(Thing t);
	   public Collection<Thing> openid();
	   public FoafThing schoolHomepage(Thing t);
	   public Collection<Thing> schoolHomepage();
	   public FoafThing pastProject(Thing t);
	   public Collection<Thing> pastProject();
	   public FoafThing plan(String s);
	   public Collection<String> plan();
	   public FoafThing myersBriggs(String s);
	   public Collection<String> myersBriggs();
	   public FoafThing mbox(Thing t);
	   public Collection<Thing> mbox();
	   @Functional
	   public FoafThing gender(String s);
	   public String gender();
	   public FoafThing sha1(Thing t);
	   public Collection<Thing> sha1();
	   public FoafThing publications(Thing t);
	   public Collection<Thing> publications();
	   public FoafThing holdsAccount(Thing t);
	   public Collection<Thing> holdsAccount();
	   public FoafThing currentProject(Thing t);
	   public Collection<Thing> currentProject();
	   public FoafThing workInfoHomepage(Thing t);
	   public Collection<Thing> workInfoHomepage();
	   public FoafThing made(Thing t);
	   public Collection<Thing> made();
	   public FoafThing aimChatID(String s);
	   public Collection<String> aimChatID();
	   @Functional
	   public FoafThing primaryTopic(Thing t);
	   public Thing primaryTopic();
	   public FoafThing thumbnail(Thing t);
	   public Collection<Thing> thumbnail();
	   public FoafThing based_near(Thing t);
	   public Collection<Thing> based_near();
	   public FoafThing workplaceHomepage(Thing t);
	   public Collection<Thing> workplaceHomepage();
	   public FoafThing logo(Thing t);
	   public Collection<Thing> logo();
	   public FoafThing weblog(Thing t);
	   public Collection<Thing> weblog();
	   public FoafThing title(Thing t);
	   public Collection<Thing> title();
	   public FoafThing fundedBy(Thing t);
	   public Collection<Thing> fundedBy();
	   public FoafThing depiction(Thing t);
	   public Collection<Thing> depiction();
	   public FoafThing accountServiceHomepage(Thing t);
	   public Collection<Thing> accountServiceHomepage();
	   public FoafThing page(Thing t);
	   public Collection<Thing> page();
	   public FoafThing isPrimaryTopicOf(Thing t);
	   public Collection<Thing> isPrimaryTopicOf();
	   public FoafThing surname(String s);
	   public Collection<String> surname();
	   public FoafThing firstName(String s);
	   public Collection<String> firstName();
	   public FoafThing homepage(Thing t);
	   public Collection<Thing> homepage();
	   public FoafThing knows(Thing t);
	   public Collection<Thing> knows();
	   public FoafThing depicts(Thing t);
	   public Collection<Thing> depicts();
	   public FoafThing interest(Thing t);
	   public Collection<Thing> interest();
	   public FoafThing geekcode(String s);
	   public Collection<String> geekcode();
	   public FoafThing mbox_sha1sum(String s);
	   public Collection<String> mbox_sha1sum();
	   public FoafThing accountName(String s);
	   public Collection<String> accountName();
	   public FoafThing membershipClass(Thing t);
	   public Collection<Thing> membershipClass();
	   public FoafThing tipjar(Thing t);
	   public Collection<Thing> tipjar();
	   public FoafThing maker(Thing t);
	   public Collection<Thing> maker();
	   public FoafThing name(String s);
	   public Collection<String> name();
	   public FoafThing img(Thing t);
	   public Collection<Thing> img();
	   @Functional
	   public FoafThing birthday(String s);
	   public String birthday();
	   public FoafThing givenname(Thing t);
	   public Collection<Thing> givenname();
	   public FoafThing member(Thing t);
	   public Collection<Thing> member();
	   public FoafThing yahooChatID(String s);
	   public Collection<String> yahooChatID();
	   public FoafThing icqChatID(String s);
	   public Collection<String> icqChatID();
	   public FoafThing phone(Thing t);
	   public Collection<Thing> phone();
	   public FoafThing topic_interest(Thing t);
	   public Collection<Thing> topic_interest();


}

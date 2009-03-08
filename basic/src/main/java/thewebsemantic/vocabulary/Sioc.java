package thewebsemantic.vocabulary;

import java.util.Collection;

import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://rdfs.org/sioc/ns#")
public interface Sioc extends Rdfs {
	public interface Community extends Sioc {};

	public interface Container extends Sioc {};

	public interface Forum extends Sioc {};

	public interface Item extends Sioc {};

	public interface Post extends Sioc {};

	public interface Role extends Sioc {};

	public interface Site extends Sioc {};

	public interface Space extends Sioc {};

	public 	interface Thread extends Sioc {};

	public interface User extends Sioc {};

	public interface UserGroup extends Sioc {};

	Collection<Thing> previous_version();
	Sioc previous_version(Thing t);
	Collection<Thing> next_version();
	Sioc next_version(Thing t);
	Collection<Thing> topic();
	Sioc topic(Object t);
	Collection<Thing> avatar();
	Sioc avatar(Thing t);
	Collection<Thing> links_to();
	Sioc links_to(Thing t);
	Collection<Thing> has_subscriber();
	Sioc has_subscriber(Thing t);
	Collection<Thing> moderator_of();
	Sioc moderator_of(Thing t);
	Collection<Thing> has_creator();
	Sioc has_creator(Object t);
	Collection<Thing> member_of();
	Sioc member_of(Thing t);
	Collection<Thing> has_function();
	Sioc has_function(Thing t);
	Collection<Thing> subscriber_of();
	Sioc subscriber_of(Thing t);
	Collection<Thing> usergroup_of();
	Sioc usergroup_of(Thing t);
	Collection<Thing> has_owner();
	Sioc has_owner(Thing t);
	Collection<Thing> parent_of();
	Sioc parent_of(Thing t);
	Collection<Thing> has_reply();
	Sioc has_reply(Object t);
	Collection<Thing> has_member();
	Sioc has_member(Thing t);
	Collection<Thing> has_container();
	Sioc has_container(Thing t);
	Collection<Thing> previous_by_date();
	Sioc previous_by_date(Thing t);
	Collection<Thing> has_space();
	Sioc has_space(Thing t);
	Collection<Thing> has_parent();
	Sioc has_parent(Thing t);
	Collection<Thing> next_by_date();
	Sioc next_by_date(Thing t);
	Collection<Thing> has_administrator();
	Sioc has_administrator(Thing t);
	Collection<Thing> has_usergroup();
	Sioc has_usergroup(Thing t);
	Collection<Thing> administrator_of();
	Sioc administrator_of(Thing t);
	Collection<Thing> modifier_of();
	Sioc modifier_of(Thing t);
	Collection<Thing> scope_of();
	Sioc scope_of(Thing t);
	Collection<Thing> has_moderator();
	Sioc has_moderator(Thing t);
	Collection<Thing> account_of();
	Sioc account_of(Thing t);
	Collection<Thing> latest_version();
	Sioc latest_version(Thing t);
	Collection<Thing> container_of();
	Sioc container_of(Thing t);
	Collection<Thing> host_of();
	Sioc host_of(Thing t);
	Collection<Thing> has_host();
	Sioc has_host(Thing t);
	Collection<Thing> has_modifier();
	Sioc has_modifier(Thing t);
	Collection<Thing> reply_of();
	Sioc reply_of(Thing t);
	Collection<Thing> has_discussion();
	Sioc has_discussion(Thing t);
	Collection<Thing> owner_of();
	Sioc owner_of(Thing t);
	Collection<Thing> has_scope();
	Sioc has_scope(Thing t);
	Collection<Thing> attachment();
	Sioc attachment(Thing t);
	Collection<Thing> creator_of();
	Sioc creator_of(Thing t);
	Collection<Thing> email();
	Sioc email(Thing t);
	Collection<Thing> reference();
	Sioc reference(Thing t);
	Collection<Thing> function_of();
	Sioc function_of(Thing t);
	Collection<Thing> space_of();
	Sioc space_of(Thing t);
	Sioc about(Thing resource);

	Collection<Thing> about();

	Sioc content(Object o);

	Object content();

	Sioc num_views(int i);

	int num_views();

	Sioc id(String s);

	String id();

	Sioc ip_address(String s);

	String ip_address();

	Sioc num_replies(int i);

	int num_replies();

	Sioc note(String s);

	String note();

	Sioc email_sha1(String s);

	String email_sha1();

	Sioc name(String s);

	String name();
	
	Sioc description(String s);
	String description();

}

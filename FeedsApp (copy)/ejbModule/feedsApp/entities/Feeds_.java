package feedsApp.entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-11-01T18:15:11.003+0200")
@StaticMetamodel(Feeds.class)
public class Feeds_ {
	public static volatile SingularAttribute<Feeds, Integer> feedId;
	public static volatile SingularAttribute<Feeds, String> title;
	public static volatile SingularAttribute<Feeds, String> body;
	public static volatile SingularAttribute<Feeds, String> writer;
	public static volatile SingularAttribute<Feeds, Date> postDate;
	public static volatile SingularAttribute<Feeds, String> category;
}

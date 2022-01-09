package thewebsemantic.vocabulary;

/*-
 * #%L
 * Jenabean binding library for RDF
 * %%
 * Copyright (C) 2015 thewebsemantic
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Collection;

import thewebsemantic.As;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://www.purl.org/stuff/rev#")
public interface ReviewVocab extends As {
	   interface Review extends ReviewVocab {}
	   interface Comment extends ReviewVocab {}
	   interface Feedback extends ReviewVocab {}
	   ReviewVocab hasReview(Object t);
	   Collection<Thing> hasReview();
	   ReviewVocab commenter(Object t);
	   Collection<Thing> commenter();
	   ReviewVocab hasComment(Object t);
	   Collection<Thing> hasComment();
	   ReviewVocab hasFeedback(Object t);
	   Collection<Thing> hasFeedback();
	   ReviewVocab rating(Object o);
	   int rating();
	   ReviewVocab type(Object o);
	   Collection<String> type();
	   ReviewVocab reviewer(Object t);
	   Collection<Thing> reviewer();
	   ReviewVocab title(Object o);
	   Collection<String> title();
	   ReviewVocab positiveVotes(Object o);
	   Collection<String> positiveVotes();
	   ReviewVocab totalVotes(Object o);
	   Collection<String> totalVotes();
	   ReviewVocab text(Object o);
	   Collection<String> text();
}

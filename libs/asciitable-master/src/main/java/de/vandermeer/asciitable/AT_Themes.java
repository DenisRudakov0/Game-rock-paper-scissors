/* Copyright 2017 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.asciitable;

import de.vandermeer.translation.targets.Text2Html;
import de.vandermeer.translation.targets.Text2Latex;

/**
 * Collection of themes for an {@link AsciiTable}.
 * 
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.3.2 build 170502 (02-May-17) for Java 1.8
 * @since      v0.3.0
 */
public interface AT_Themes {

	/**
	 * A theme for LaTeX target, setting the translator.
	 * @return the theme
	 */
	static AsciiTableTheme latex(){
		return new AsciiTableTheme() {
			@Override
			public void apply(AsciiTable table) {
				table.setTargetTranslator(new Text2Latex());
			}
		};
	}

	/**
	 * A theme for HTML target, setting the translator.
	 * @return the theme
	 */
	static AsciiTableTheme html(){
		return new AsciiTableTheme() {
			@Override
			public void apply(AsciiTable table) {
				table.setTargetTranslator(new Text2Html());
			}
		};
	}
}

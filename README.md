iHome
=====

iHome 是一个基于SpringMVC、shiro的demo.

...

<plugin>
				<groupId>org.mortbay.jetty</groupId>
				<artifactId>maven-jetty-plugin</artifactId>
				<configuration>
					<scanIntervalSeconds>3</scanIntervalSeconds>
					<stopKey>foo</stopKey>
					<stopPort>9999</stopPort>
					<connectors>
						<connector implementation="org.mortbay.jetty.nio.SelectChannelConnector">
							<port>8181</port>
							<maxIdleTime>60000</maxIdleTime>
						</connector>
					</connectors>
					<webDefaultXml>webdefault.xml</webDefaultXml>
				</configuration>
				<executions>
					<execution>
						<id>start-jetty</id>
						<phase>pre-integration-test</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<scanIntervalSeconds>0</scanIntervalSeconds>
							<daemon>true</daemon>
						</configuration>
					</execution>
					<execution>
						<id>stop-jetty</id>
						<phase>post-integration-test</phase>
						<goals>
							<goal>stop</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			
...			
			

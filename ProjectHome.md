<table>
<tr>
<td width='100%' valign='top'>
<p>
DKPro Keyphrases is a collection of software components for keyphrases extraction based on Apache UIMA Framework and DKPro Core. This project was initiated by the Ubiquitous Knowledge Processing Lab (UKP) at the Technische Universität Darmstadt, Germany under the auspices of Prof. Dr. Iryna Gurevych. This work has been supported by the German Federal Ministry of Education and Research (BMBF) within the context of the Software Campus project <b>Open Window</b> under grant No. 01IS12054. The UKP Labs assumes responsibility for the content.<br>
</p>

This set of software components implement powerful state-of-the-art keyphrase extractions techniques, as it also presents new ones being developed at UKP Labs. These components are being developed and released continuously. Since it is build heavily on uimaFIT, it permits a rapid and easy development of pipelines which uses keyphrase extraction.<br>
<br>
The modules from DKPro Keyphrases are released under ASL and GPL licenses.<br>
</td>
<td valign='top'>

<wiki:gadget url="http://www.ohloh.net/p/643513/widgets/project_factoids_stats.xml" height="270" width="400" border="1"/><br />
<table>
<tr>
<td valign='middle'>
<wiki:gadget url="http://www.ohloh.net/p/643513/widgets/project_users_logo.xml" height="43" border="0"/><br>
</td>
</tr>
</table>
</td>
</tr>
</table>

## Getting it ##

DKPro Keyphrases is not on maven central yet, so, to use it, it is necessary to change your settings.xml file under ~/.m2 folder to add the zoidberg repository from UKP. There is a tutorial in the [DKPro-Core ASL wiki](https://code.google.com/p/dkpro-core-asl/wiki/UkpMavenRepository) which explains how to do it.

After changing the settings.xml file, DKPro Keyphrases can be added to the project by adding these tags to the pom file:

```
<dependency>
  <groupId>de.tudarmstadt.ukp.dkpro.keyphrases</groupId>
  <artifactId>de.tudarmstadt.ukp.dkpro.keyphrases.core-asl</artifactId>
  <version>1.5.0-SNAPSHOT</version>
</dependency>
```
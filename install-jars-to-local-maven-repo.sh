mvn dependency:purge-local-repository -DmanualInclude="org.nibs.cobie:tabs,org.openmali:openmali,org.buildingsmartalliance.docs.nbims03.cobie:cobielite,com.saxonica.xqj:saxon9_7,net.sf.saxon:saxon9_7he,org.bimserver.shared.cobie.generated:COBieMergeIDM,nl.fountain:xelem,org.bimserver.cobies:cobieserializersettings,org.bimserver.shared.cobie:compare"

mvn install:install-file -Dfile=lib/cobietab.jar -DgroupId=org.nibs.cobie -DartifactId=tabs -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/openmali.jar -DgroupId=org.openmali -DartifactId=openmali -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/lcie.jar -DgroupId=org.buildingsmartalliance.docs.nbims03.cobie -DartifactId=cobielite -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/saxon9_7-xqj.jar -DgroupId=com.saxonica.xqj -DartifactId=saxon9_7 -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/saxon9_7he.jar -DgroupId=net.sf.saxon -DartifactId=saxon9_7he -Dversion=9.7 -Dpackaging=jar

mvn install:install-file -Dfile=lib/COBieMergeIDM.jar -DgroupId=org.bimserver.shared.cobie.generated -DartifactId=COBieMergeIDM -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/xelem.jar -DgroupId=nl.fountain -DartifactId=xelem -Dversion=3.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/COBieSerializerSettings.jar -DgroupId=org.bimserver.cobies -DartifactId=cobieserializersettings -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/COBieCompare.jar -DgroupId=org.bimserver.shared.cobie -DartifactId=compare -Dversion=1.0 -Dpackaging=jar
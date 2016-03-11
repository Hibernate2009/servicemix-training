<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:bss="http://bssys.com/training">
	<xsl:param name="statementId"></xsl:param>
	<xsl:template match="/">
		<x:Ticket xmlns:x="RootExt_Ticket">
			<statementId>
				<xsl:value-of select="$statementId"/>
			</statementId>
			<MessageData>
				<xsl:copy-of select="/"/>
			</MessageData>
		</x:Ticket>
	</xsl:template>
</xsl:stylesheet>
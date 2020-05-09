package com.lutfi.cleanarchitecture.util.nfc.parser

import android.nfc.NdefMessage
import android.nfc.NdefRecord
import com.lutfi.cleanarchitecture.util.nfc.record.ParsedNdefRecord
import com.lutfi.cleanarchitecture.util.nfc.record.SmartPoster
import com.lutfi.cleanarchitecture.util.nfc.record.TextRecord
import com.lutfi.cleanarchitecture.util.nfc.record.UriRecord


/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

object NdefMessageParser {

    fun parse(message: NdefMessage): List<ParsedNdefRecord> {
        return getRecords(message.records)
    }

    fun getRecords(records: Array<NdefRecord>): List<ParsedNdefRecord> {
        val elements = ArrayList<ParsedNdefRecord>()

        for (record in records) {
            when {
                UriRecord.isUri(record) -> {
                    elements.add(UriRecord.parse(record))
                }
                TextRecord.isText(record) -> {
                    elements.add(TextRecord.parse(record))
                }
                SmartPoster.isPoster(record) -> {
                    elements.add(SmartPoster.parse(record))
                }
                else -> {
                    elements.add(object : ParsedNdefRecord {
                        override fun str(): String {
                            return String(record.payload)
                        }
                    })
                }
            }
        }

        return elements
    }
}
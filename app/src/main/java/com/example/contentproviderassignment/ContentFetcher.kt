package com.example.contentproviderassignment

import android.content.Context
import android.content.CursorLoader
import android.provider.Telephony

class ContentFetcher (val context: Context){
    fun fetchall():ArrayList<Mess>{
        val fields= arrayOf(
            Telephony.Sms.ADDRESS,
            Telephony.Sms.BODY
        )
        val listSms=ArrayList<Mess>()

        val curLoader=CursorLoader(
            context,
            Telephony.Sms.CONTENT_URI,
            fields,
            null,
            null,
            null
        )
        val cursor=curLoader.loadInBackground()
        if(cursor.moveToFirst())
        {
            val idIndex=cursor.getColumnIndex(Telephony.Sms.ADDRESS)
            val txtIndex=cursor.getColumnIndex(Telephony.Sms.BODY)
            do {
                var id=cursor.getString(idIndex)
                var txt=cursor.getString(txtIndex)
                if (id!=null&&txtIndex!=null)
                {
                    var mess=Mess(id,txt)
                    listSms.add(mess)
                }
            }while (cursor.moveToNext())
        }
        return listSms
    }
}

//                val contactId = cursor.getString(idIndex)
//                var contactDisplayName = ""
//                var number=""
//                if (cursor.getString(nameIndex) != null){
//                    contactDisplayName = cursor.getString(nameIndex)
//                }
//                val contact = Contact(contactId, number)
//                contactsMap[contactId] = contact
//                listContacts.add(contact)
//            } while (cursor.moveToNext())
//        }
//        cursor.close()
//        return listContacts
//    }
//}
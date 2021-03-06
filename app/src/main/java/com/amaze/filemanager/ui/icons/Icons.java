/*
 * Copyright (C) 2014 Arpit Khurana <arpitkh96@gmail.com>, Vishal Nehra <vishalmeham2@gmail.com>
 *
 * This file is part of Amaze File Manager.
 *
 * Amaze File Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.ui.icons;

import android.support.annotation.DrawableRes;

import com.amaze.filemanager.R;
import com.amaze.filemanager.utils.files.CryptUtil;

import java.io.File;
import java.util.HashMap;

public class Icons {

    public static final int VIDEO = 0, AUDIO = 1, PDF = 2, CODE = 3, TEXT = 4, ARCHIVE = 5,
            GENERIC = 6, APK = 7, PICTURE = 8, ENCRYPTED = 9;

    // construct a with an approximation of the capacity
    private static HashMap<String, Integer> sMimeIconIds = new HashMap<>(1 + (int)(114 / 0.75));

    private static void add(String mimeType, int resId) {
        if (sMimeIconIds.put(mimeType, resId) != null) {
            throw new RuntimeException(mimeType + " already registered!");
        }
    }

    private static void add(int resId, String... mimeTypes) {
        for (String type : mimeTypes) {
            add(type, resId);
        }
    }

    static {
        // Package
        add(R.drawable.ic_doc_apk_white,
                "application/vnd.android.package-archive"
        );

// Audio
        add(R.drawable.ic_doc_audio_am,
                "application/ogg",
                "application/x-flac"
        );

// Certificate
        add(R.drawable.ic_doc_certificate,
                "application/pgp-keys",
                "application/pgp-signature",
                "application/x-pkcs12",
                "application/x-pkcs7-certreqresp",
                "application/x-pkcs7-crl",
                "application/x-x509-ca-cert",
                "application/x-x509-user-cert",
                "application/x-pkcs7-certificates",
                "application/x-pkcs7-mime",
                "application/x-pkcs7-signature"
        );

// Source code
        add(R.drawable.ic_doc_codes,
                "application/rdf+xml",
                "application/rss+xml",
                "application/x-object",
                "application/xhtml+xml",
                "text/css",
                "text/html",
                "text/xml",
                "text/x-c++hdr",
                "text/x-c++src",
                "text/x-chdr",
                "text/x-csrc",
                "text/x-dsrc",
                "text/x-csh",
                "text/x-haskell",
                "text/x-java",
                "text/x-literate-haskell",
                "text/x-pascal",
                "text/x-tcl",
                "text/x-tex",
                "application/x-latex",
                "application/x-texinfo",
                "application/atom+xml",
                "application/ecmascript",
                "application/json",
                "application/javascript",
                "application/xml",
                "text/javascript",
                "application/x-javascript"
        );

// Compressed
        add(R.drawable.ic_zip_box_white_36dp,
                "application/mac-binhex40",
                "application/rar",
                "application/zip",
                "application/java-archive",
                "application/x-apple-diskimage",
                "application/x-debian-package",
                "application/x-gtar",
                "application/x-iso9660-image",
                "application/x-lha",
                "application/x-lzh",
                "application/x-lzx",
                "application/x-stuffit",
                "application/x-tar",
                "application/x-webarchive",
                "application/x-webarchive-xml",
                "application/gzip",
                "application/x-7z-compressed",
                "application/x-deb",
                "application/x-rar-compressed"
        );

// Contact
        add(R.drawable.ic_doc_contact_am,
                "text/x-vcard",
                "text/vcard"
        );

// Event
        add(R.drawable.ic_doc_event_am,
                "text/calendar",
                "text/x-vcalendar"
        );

// Font
        add(R.drawable.ic_doc_font,
                "application/x-font",
                "application/font-woff",
                "application/x-font-woff",
                "application/x-font-ttf"
        );

// Image
        add(R.drawable.ic_doc_image,
                "application/vnd.oasis.opendocument.graphics",
                "application/vnd.oasis.opendocument.graphics-template",
                "application/vnd.oasis.opendocument.image",
                "application/vnd.stardivision.draw",
                "application/vnd.sun.xml.draw",
                "application/vnd.sun.xml.draw.template",
                "image/jpeg",
                "image/png"
        );

// PDF
        add(R.drawable.ic_doc_pdf,
                "application/pdf"
        );

// Presentation
        add(R.drawable.ic_doc_presentation,
                "application/vnd.ms-powerpoint",
                "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                "application/vnd.openxmlformats-officedocument.presentationml.template",
                "application/vnd.openxmlformats-officedocument.presentationml.slideshow",
                "application/vnd.stardivision.impress",
                "application/vnd.sun.xml.impress",
                "application/vnd.sun.xml.impress.template",
                "application/x-kpresenter",
                "application/vnd.oasis.opendocument.presentation"
        );

// Spreadsheet
        add(R.drawable.ic_doc_spreadsheet_am,
                "application/vnd.oasis.opendocument.spreadsheet",
                "application/vnd.oasis.opendocument.spreadsheet-template",
                "application/vnd.ms-excel",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.template",
                "application/vnd.stardivision.calc",
                "application/vnd.sun.xml.calc",
                "application/vnd.sun.xml.calc.template",
                "application/x-kspread",
                "text/comma-separated-values"
        );

// Doc
        add(R.drawable.ic_doc_doc_am,
                "application/msword",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.template",
                "application/vnd.oasis.opendocument.text",
                "application/vnd.oasis.opendocument.text-master",
                "application/vnd.oasis.opendocument.text-template",
                "application/vnd.oasis.opendocument.text-web",
                "application/vnd.stardivision.writer",
                "application/vnd.stardivision.writer-global",
                "application/vnd.sun.xml.writer",
                "application/vnd.sun.xml.writer.global",
                "application/vnd.sun.xml.writer.template",
                "application/x-abiword",
                "application/x-kword",
                "text/markdown"
        );

// Text
        add(R.drawable.ic_doc_text_am,
                "text/plain"
        );

// Video
        add(R.drawable.ic_doc_video_am,
                "application/x-quicktimeplayer",
                "application/x-shockwave-flash"
        );
    }

    public static boolean isText(File file) {
        String mimeType = MimeTypes.getMimeType(file);

        Integer res = sMimeIconIds.get(mimeType);
        if (res != null && res == R.drawable.ic_doc_text_am) return true;
        if (mimeType != null && mimeType.contains("/")) {
            final String typeOnly = mimeType.split("/")[0];
            if ("text".equals(typeOnly)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVideo(File file) {
        String mimeType = MimeTypes.getMimeType(file);
        Integer res = sMimeIconIds.get(mimeType);
        if (res != null && res == R.drawable.ic_doc_video_am) return true;
        if (mimeType != null && mimeType.contains("/")) {
            final String typeOnly = mimeType.split("/")[0];
            if ("video".equals(typeOnly)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEncrypted(File file) {
        return file.getName().endsWith(CryptUtil.CRYPT_EXTENSION);
    }

    public static boolean isAudio(File file) {
        String mimeType = MimeTypes.getMimeType(file);
        Integer res = sMimeIconIds.get(mimeType);
        if (res != null && res == R.drawable.ic_doc_audio_am) return true;
        if (mimeType != null && mimeType.contains("/")) {
            final String typeOnly = mimeType.split("/")[0];
            if ("audio".equals(typeOnly)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCode(File file) {
        Integer res = sMimeIconIds.get(MimeTypes.getMimeType(file));
        return res != null && res == R.drawable.ic_doc_codes;
    }

    public static boolean isArchive(File file) {
        Integer res = sMimeIconIds.get(MimeTypes.getMimeType(file));
        return res != null && res == R.drawable.ic_zip_box_white_36dp;
    }

    public static boolean isApk(File file) {
        Integer res = sMimeIconIds.get(MimeTypes.getMimeType(file));
        return res != null && res == R.drawable.ic_doc_apk_white;
    }

    public static boolean isPdf(File file) {
        Integer res = sMimeIconIds.get(MimeTypes.getMimeType(file));
        return res != null && res == R.drawable.ic_doc_pdf;
    }

    public static boolean isPicture(File file) {
        Integer res = sMimeIconIds.get(MimeTypes.getMimeType(file));
        return res != null && res == R.drawable.ic_doc_image;
    }

    public static boolean isGeneric(File file) {
        String mimeType = MimeTypes.getMimeType(file);
        if (mimeType == null) {
            return true;
        }
        Integer resId = sMimeIconIds.get(mimeType);

        return resId == null;
    }

    public static int getTypeOfFile(String filePath) {
        File file = new File(filePath);

        if (Icons.isVideo(file))
            return VIDEO;
        else if (Icons.isAudio(file))
            return AUDIO;
        else if (Icons.isPdf(file))
            return PDF;
        else if (Icons.isCode(file))
            return CODE;
        else if (Icons.isText(file))
            return TEXT;
        else if (Icons.isArchive(file))
            return ARCHIVE;
        else if (Icons.isGeneric(file))
            return GENERIC;
        else if (Icons.isApk(file))
            return APK;
        else if (Icons.isPicture(file))
            return PICTURE;
        else if (Icons.isEncrypted(file))
            return ENCRYPTED;
        else return -1;
    }

    public static @DrawableRes int loadMimeIcon(String path, boolean grid) {
        if(path.equals("..")) return R.drawable.ic_arrow_left_white_24dp;

        File f = new File(path);
        if(f.isDirectory()) {
            if(path.endsWith(CryptUtil.CRYPT_EXTENSION)) return R.drawable.ic_folder_lock_white_36dp;
            else return R.drawable.ic_grid_folder_new;
        }

        String mimeType = MimeTypes.getMimeType(f);
        if (mimeType == null) {
            /* if(grid) return loadBitmapDrawableById(res, R.drawable.ic_doc_generic_am_grid);*/
            return R.drawable.ic_doc_generic_am;
        }

        // Look for exact match first
        Integer resId = sMimeIconIds.get(mimeType);

        if (resId != null) {
            switch (resId) {
                case R.drawable.ic_doc_apk_white:
                    if (grid) resId = R.drawable.ic_doc_apk_grid;
                    break;/*
            case R.drawable.ic_doc_audio_am: if(grid)resId=R.drawable.ic_doc_audio_am_grid;
                break;
            case R.drawable.ic_doc_certificate: if(grid)resId=R.drawable.ic_doc_certificate_grid;
                break;
            case R.drawable.ic_doc_codes: if(grid)resId=R.drawable.ic_doc_codes_grid;
                break;
            case R.drawable.ic_doc_font: if(grid)resId=R.drawable.ic_doc_font_grid;
                break;
            case R.drawable.ic_doc_generic_am: if(grid)resId=R.drawable.ic_doc_generic_am_grid;
                break;
            */
                case R.drawable.ic_doc_image:
                    if (grid) resId = R.drawable.ic_doc_image_grid;
                    break;
            }
            /*case R.drawable.ic_doc_pdf: if(grid)resId=R.drawable.ic_doc_pdf_grid;
                break;
            case R.drawable.ic_doc_video_am: if(grid)resId=R.drawable.ic_doc_video_am_grid;
                break;
            case R.drawable.ic_doc_text_am: if(grid)resId=R.drawable.ic_doc_text_am_grid;
                break;
        }*/
            return resId;
        }

        // Otherwise look for partial match
        final String typeOnly = mimeType.split("/")[0];

        if ("audio".equals(typeOnly)) {
           /* if (grid) resId = R.drawable.ic_doc_audio_am_grid; else*/
            resId = R.drawable.ic_doc_audio_am;
        } else if ("image".equals(typeOnly)) {
            if (grid) resId =  R.drawable.ic_doc_image_grid;
            else resId = R.drawable.ic_doc_image;
        } else if ("text".equals(typeOnly)) {
            /*if (grid) resId = R.drawable.ic_doc_text_am_grid; else*/
            resId = R.drawable.ic_doc_text_am;
        } else if ("video".equals(typeOnly)) {
            /*if (grid) resId = R.drawable.ic_doc_video_am_grid; else*/
            resId = R.drawable.ic_doc_video_am;
        } else if (path.endsWith(CryptUtil.CRYPT_EXTENSION)) {
            resId = R.drawable.ic_file_lock_white_36dp;
        }
        if (resId == null) {
            /*if (grid) resId = R.drawable.ic_doc_generic_am_grid; else*/
            resId = R.drawable.ic_doc_generic_am;
        }
        return resId;
    }

}

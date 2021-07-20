package com.inetBanking.utilities;

import sun.security.x509.InvalidityDateExtension;

public enum EnumDropDown {

    INDEX{
        @Override
        public String toString() {
            return "index";
        }
    },
    VALUE{
        @Override
        public String toString() {
            return "value";
        }
    },
    VISIBLETEXT {
        @Override
        public String toString() {
            return "visibletext";
        }
    }
}

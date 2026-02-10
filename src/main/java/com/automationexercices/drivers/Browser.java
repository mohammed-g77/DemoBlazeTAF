package com.automationexercices.drivers;

public enum Browser {
    CHROME {
        @Override
        public AbstractDriver getDriverFactory() {
            return new ChromeFactory();
        }
    },
    EDGE {
        @Override
        public AbstractDriver getDriverFactory() {
            return new EdgeFactory();
        }
    },
    FIARFOX {
        @Override
        public AbstractDriver getDriverFactory() {
            return new FirefoxFactory();
        }
    };

    public abstract  AbstractDriver getDriverFactory();

}
